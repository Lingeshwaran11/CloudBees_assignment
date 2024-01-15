package com.trainticket.TrainTicket;


import com.trainticket.models.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service
public class TrainTicketAppServer extends TrainTicketAppGrpc.TrainTicketAppImplBase {

    private Server server;

    @PostConstruct
    public void start() throws IOException {
        // Start the gRPC server
        int port = 8080; // Choose a suitable port
        server = ServerBuilder.forPort(port)
                .addService(this)  // Use 'this' to reference the current instance
                .build()
                .start();
        System.out.println("started");
    }


    @PreDestroy
    public void stop() {
        // Stop the gRPC server
        if (server != null) {
            server.shutdown();
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        // Block until the server is terminated
        if (server != null) {
            server.awaitTermination();
        }
    }
    private TrainTicketClient trainTicketClient;


    private Map<String, Receipt> receipts;
    private Map<String, User> users;

    public TrainTicketAppServer() {
        this.receipts = new HashMap<>();
        this.users = new HashMap<>();
    }
    public TrainTicketAppServer(TrainTicketClient trainTicketClient) {
        this.trainTicketClient = trainTicketClient;
    }

    @Override
    public void purchaseTicket(PurchaseTicketRequest request, StreamObserver<PurchaseTicketResponse> responseObserver) {
        String from = request.getFrom();
        String to = request.getTo();
        String userId = String.format("U-%d", users.size() + 1);

        User user = User.newBuilder()
                .setId(userId)
                .setFirstName(request.getUser().getFirstName())
                .setLastName(request.getUser().getLastName())
                .setEmail(request.getUser().getEmail())
                .build();

        // Select randomly from sections
        String[] sections = {"A", "B"};
        String section = sections[new Random().nextInt(sections.length)];

        Receipt receipt = Receipt.newBuilder()
                .setId(String.format("RT-%d", receipts.size() + 1))
                .setFrom(from)
                .setTo(to)
                .setUser(user)
                .setPrice(20.0f)
                .setSection(section)
                .build();

        receipts.put(receipt.getId(), receipt);
        users.put(user.getId(), user);
        System.out.println("All Users:");
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User user1 = entry.getValue();
            System.out.println("User ID: " + entry.getKey());
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("--------------------");
        }

        PurchaseTicketResponse response = PurchaseTicketResponse.newBuilder()
                .setReceipt(Receipt.newBuilder()
                        .setId(receipt.getId())
                        .setFrom(receipt.getFrom())
                        .setTo(receipt.getTo())
                        .setPrice(receipt.getPrice())
                        .setSection(receipt.getSection())
                        .setUser(User.newBuilder()
                                .setId(userId)
                                .setFirstName(user.getFirstName())
                                .setLastName(user.getLastName())
                                .setEmail(user.getEmail())
                                .build())
                        .build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getReceiptDetails(GetReceiptDetailsRequest request, StreamObserver<GetReceiptDetailsResponse> responseObserver) {
        String receiptID = request.getReceiptID();

        Receipt receipt = receipts.get(receiptID);
        if (receipt == null) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(String.format("Receipt with ID %s not found", receiptID)).asRuntimeException());
            return;
        }

        GetReceiptDetailsResponse response = GetReceiptDetailsResponse.newBuilder()
                .setReceipt(Receipt.newBuilder()
                        .setId(receipt.getId())
                        .setFrom(receipt.getFrom())
                        .setTo(receipt.getTo())
                        .setSection(receipt.getSection())
                        .setPrice(receipt.getPrice())
                        .setUser(User.newBuilder()
                                .setId(String.format("U-%d", users.size() + 1))
                                .setFirstName(receipt.getUser().getFirstName())
                                .setLastName(receipt.getUser().getLastName())
                                .setEmail(receipt.getUser().getEmail())
                                .build())
                        .build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUsersBySection(GetUsersBySectionRequest request, StreamObserver<GetUsersBySectionResponse> responseObserver) {
        String section = request.getSection();

        GetUsersBySectionResponse.Builder responseBuilder = GetUsersBySectionResponse.newBuilder();
        for (Receipt r : receipts.values()) {
            if (r.getSection().equals(section)) {
                User user = User.newBuilder()
                        .setId(String.format("U-%d", users.size() + 1))
                        .setFirstName(r.getUser().getFirstName())
                        .setLastName(r.getUser().getLastName())
                        .setEmail(r.getUser().getEmail())
                        .build();
                responseBuilder.addUsers(user);
            }
        }

        GetUsersBySectionResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void removeUser(RemoveUserRequest request, StreamObserver<RemoveUserResponse> responseObserver) {
        String userID = request.getUserID();
        System.out.println("Received request to remove user with ID: " + userID);
        if (!users.containsKey(userID)) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(String.format("User with ID %s not found", userID)).asRuntimeException());
            return;
        }

        // Print users before removal
        System.out.println("Users before removal:");
        printAllUsers();

        users.remove(userID);

        RemoveUserResponse response = RemoveUserResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        // Print users after removal
        System.out.println("Users after removal:");
        printAllUsers();
    }

    private void printAllUsers() {
        System.out.println("All Users:");
        for (User user : users.values()) {
            printUserData(user);
        }
    }

    private void printUserData(User user) {
        System.out.println("User ID: " + user.getId());
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("--------------------");
    }

    @Override
    public void modifyUserSeat(ModifyUserSeatRequest request, StreamObserver<ModifyUserSeatResponse> responseObserver) {
        String receiptID = request.getReceiptID();
        String newSection = request.getNewSection();

        Receipt receipt = receipts.get(receiptID);
        if (receipt == null) {
            responseObserver.onError(Status.NOT_FOUND.withDescription(String.format("Receipt with ID %s not found", receiptID)).asRuntimeException());
            return;
        }

        String oldSection = receipt.getSection();
        receipt = receipt.toBuilder().setSection(newSection).build();
        receipts.put(receiptID, receipt);

        ModifyUserSeatResponse response = ModifyUserSeatResponse.newBuilder()
                .setOldSection(oldSection)
                .setNewSection(newSection)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}