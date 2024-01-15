package com.trainticket.TrainTicket;

import com.trainticket.models.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@Component
public class TrainTicketClient {

    private List<PurchaseTicketResponse> ticketResponses = new ArrayList<>();
    private List<User> users = new ArrayList<>(); // Add this line to declare and initialize the users list
    private final TrainTicketAppServer trainTicketAppServer; // Add this line

    private final ManagedChannel channel;
    private final TrainTicketAppGrpc.TrainTicketAppBlockingStub stub;
    private final Scanner scanner;

    public TrainTicketClient(TrainTicketAppServer trainTicketAppServer) {
        TrainTicketAppServer trainTicketAppServer1;
        trainTicketAppServer1 = trainTicketAppServer;
        // Create a gRPC channel
        System.out.println("Started");

        this.channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // Create a stub
        this.stub = TrainTicketAppGrpc.newBlockingStub(channel);

        // Create a Scanner for user input
        this.scanner = new Scanner(System.in);
        trainTicketAppServer1 = trainTicketAppServer;

        this.trainTicketAppServer = trainTicketAppServer1;
    }

    @PostConstruct
    public void runClientLogic() {
        boolean flag=true;
        try {
            while (flag) {
                // Display menu
                System.out.println("Select a service:");
                System.out.println("1. Purchase Ticket");
                System.out.println("2. Print All Ticket Purchases");
                System.out.println("3. Get Receipt Details");
                System.out.println("4. Get Users by Section");
                System.out.println("5. Remove User");
                System.out.println("6. Modify User Seat");
                System.out.println("0. Exit");

                // Get user choice
                int choice = getUserChoice();

                // Perform selected service
                switch (choice) {
                    case 1:
                        performPurchaseTicket();
                        break;
                    case 2:
                        printAllTicketPurchases();
                        break;
                    case 3:
                        performGetReceiptDetails();
                        break;
                    case 4:
                        performGetUsersBySection();
                        break;
                    case 5:
                        performRemoveUser();
                        break;
                    case 6:
                        performModifyUserSeat();
                        break;
                    case 0:
                        flag=false;
                        System.out.println("Thank you!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } finally {
            // Close the scanner and channel
            scanner.close();
            channel.shutdown();
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
        return scanner.nextInt();
    }

    private void performPurchaseTicket() {
        PurchaseTicketRequest purchaseRequest = getUserInputForPurchase();

        // Create a StreamObserver to handle the response
        StreamObserver<PurchaseTicketResponse> responseObserver = new StreamObserver<PurchaseTicketResponse>() {
            @Override
            public void onNext(PurchaseTicketResponse response) {
                // Extract values from the response
                Receipt receipt = response.getReceipt();
                User user = response.getReceipt().getUser();

                // Print or use the extracted values
                System.out.println("Purchase successful!");
                System.out.println("Receipt ID: " + receipt.getId());
                printReceiptAndUserData(receipt,user);

                // Add the extracted values to the appropriate lists
                ticketResponses.add(response);
                users.add(user);
            }

            @Override
            public void onError(Throwable t) {
                // Handle errors
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Handle completion
                System.out.println("Purchase completed");
            }
        };

        // Replace gRPC call with direct method call
        trainTicketAppServer.purchaseTicket(purchaseRequest, responseObserver);

    }


    private void printAllTicketPurchases() {
        System.out.println("All Ticket Purchases:");
        for (PurchaseTicketResponse response : ticketResponses) {
            Receipt receipt = response.getReceipt();
            User user = receipt.getUser();
            printReceiptAndUserData(receipt,user);
        }
    }
    private void performGetReceiptDetails() {
        try {
            scanner.nextLine();

            System.out.print("Enter the receipt ID: ");
            String receiptId = scanner.nextLine(); // Using nextLine to get user input

            System.out.println("Receipt ID: " + receiptId);

            // Create a StreamObserver to handle the response
            StreamObserver<GetReceiptDetailsResponse> responseObserver = new StreamObserver<GetReceiptDetailsResponse>() {
                @Override
                public void onNext(GetReceiptDetailsResponse response) {
                    Receipt receipt = response.getReceipt();
                    printReceiptData(receipt);
                    System.out.println("--------------------");
                }

                @Override
                public void onError(Throwable t) {
                    // Handle errors
                    System.err.println("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Handle completion
                    System.out.println("Get Receipt Details completed");
                }
            };

            // Call the getReceiptDetails method directly
            trainTicketAppServer.getReceiptDetails(
                    GetReceiptDetailsRequest.newBuilder().setReceiptID(receiptId).build(),
                    responseObserver);

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }


    private void performGetUsersBySection() {
        scanner.nextLine();
        System.out.print("Enter the section to view users: ");
        String section = scanner.nextLine(); // Using nextLine to get user input

        // Create a StreamObserver to handle the response
        StreamObserver<GetUsersBySectionResponse> responseObserver = new StreamObserver<GetUsersBySectionResponse>() {
            @Override
            public void onNext(GetUsersBySectionResponse response) {
                List<User> usersInSection = response.getUsersList();
                for (User user : usersInSection) {
                    printUserData(user);
                }
            }

            @Override
            public void onError(Throwable t) {
                // Handle errors
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Handle completion
                System.out.println("Get Users By Section completed");
            }
        };

        // Call the getUsersBySection method directly
        trainTicketAppServer.getUsersBySection(
                GetUsersBySectionRequest.newBuilder().setSection(section).build(),
                responseObserver);
    }


    private void performRemoveUser() {
        try {
            scanner.nextLine();
            System.out.print("Enter the user ID to remove: ");
            String userIdToRemove = scanner.nextLine();

            // Check if the user exists before attempting to remove
            User userToRemove = getUserById(userIdToRemove);
            if (userToRemove != null) {
                // Print user data
                printUserData(userToRemove);

                // Remove user from the list
                removeUserFromList(userIdToRemove);

                // Call the removeUser method directly
                RemoveUserRequest removeUserRequest = RemoveUserRequest.newBuilder()
                        .setUserID(userIdToRemove)
                        .build();

                StreamObserver<RemoveUserResponse> responseObserver = new StreamObserver<RemoveUserResponse>() {
                    @Override
                    public void onNext(RemoveUserResponse response) {
                        System.out.println("removeUserResponse: " + response);
                        System.out.println("User removed successfully.");
                    }

                    @Override
                    public void onError(Throwable t) {
                        // Handle errors
                        System.err.println("Error: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        // Handle completion
                        System.out.println("Remove User completed");
                    }
                };

                trainTicketAppServer.removeUser(removeUserRequest, responseObserver);
            } else {
                System.out.println("User with ID " + userIdToRemove + " not found.");
            }
        } catch (Exception e) {
            // Handle the exception gracefully
            System.out.println("Error occurred while removing the user: " + e.getMessage());
        }
    }

    private User getUserById(String userId) {
        try {
            // Implement logic to get a user by ID from the 'users' list
            return users.stream()
                    .filter(user -> user.getId().equals(userId))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            // Handle the exception gracefully, e.g., log it
            System.out.println("Error occurred while getting user by ID: " + e.getMessage());
            return null;
        }
    }


    private void removeUserFromList(String userId) {
        // Check if the user with the given ID exists before attempting to remove
        if (userId != null) {
            // Implement logic to remove the user from the 'users' list
            // For example, you can use a stream to filter out the user with the given ID
            users.removeIf(user -> user.getId().equals(userId));
            System.out.println("User removed from the list.");
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }


    private void performModifyUserSeat() {
        try {
            scanner.nextLine();
            System.out.print("Enter the receipt ID: ");
            String receiptId = scanner.nextLine();
            ModifyUserSeatRequest modifyUserSeatRequest = getUserInputForModifyUserSeat(receiptId);

            // Create a StreamObserver to handle the response
            StreamObserver<ModifyUserSeatResponse> responseObserver = new StreamObserver<ModifyUserSeatResponse>() {
                @Override
                public void onNext(ModifyUserSeatResponse response) {
                    System.out.println("User seat modified. Old Section: " + response.getOldSection() +
                            ", New Section: " + response.getNewSection());
                }

                @Override
                public void onError(Throwable t) {
                    // Handle errors
                    System.err.println("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Handle completion
                    System.out.println("Modify User Seat completed");
                }
            };

            // Call the modifyUserSeat method directly
            trainTicketAppServer.modifyUserSeat(modifyUserSeatRequest, responseObserver);

        } catch (Exception e) {
            // Handle the exception gracefully
            System.out.println("Error occurred while modifying user seat: " + e.getMessage());
        }
    }



    private PurchaseTicketRequest getUserInputForPurchase() {
        // Consume the Enter key press if there's any remaining in the buffer
        scanner.nextLine();

        System.out.println("Enter the departure city:");
        String from = scanner.nextLine();

        System.out.println("Enter the destination city:");
        String to = scanner.nextLine();

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter your email address:");
        String email;
        do {
            System.out.println("Enter your email address:");
            email = scanner.nextLine();
        } while (!isValidEmail(email));


        return PurchaseTicketRequest.newBuilder()
                .setFrom(from)
                .setTo(to)
                .setUser(User.newBuilder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .build())
                .build();
    }
    private boolean isValidEmail(String email) {
        // Regular expression for a simple email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // If the email is empty or does not match the pattern, return false
        return !email.isEmpty() && pattern.matcher(email).matches();
    }


    private String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private ModifyUserSeatRequest getUserInputForModifyUserSeat(String receiptId) {
        String newSection = getUserInput("Enter the new section:");
        return ModifyUserSeatRequest.newBuilder()
                .setReceiptID(receiptId)
                .setNewSection(newSection)
                .build();
    }
    private void printReceiptAndUserData(Receipt receipt, User user) {
        System.out.println("+----------------------+------------------------+");
        System.out.println("| Receipt Information  |   User Information      |");
        System.out.println("+----------------------+------------------------+");
        System.out.printf("| From: %-16s | User ID: %-15s   |\n", receipt.getFrom(), user.getId());
        System.out.printf("| To: %-18s | First Name: %-15s |\n", receipt.getTo(), user.getFirstName());
        System.out.printf("| Price: %-14s | Last Name: %-16s |\n", receipt.getPrice(), user.getLastName());
        System.out.printf("| Section: %-12s | Email: %-20s |\n", receipt.getSection(), user.getEmail());
        System.out.println("+----------------------+------------------------+");
    }

    private void printReceiptData(Receipt receipt) {
        System.out.println("+----------------------+");
        System.out.println("| Receipt Information  |");
        System.out.println("+----------------------+");
        System.out.printf("| From: %-15s |\n", receipt.getFrom());
        System.out.printf("| To: %-17s |\n", receipt.getTo());
        System.out.printf("| Price: %-14s |\n", receipt.getPrice());
        System.out.printf("| Section: %-12s |\n", receipt.getSection());
        System.out.println("+----------------------+");
    }
    private void printUserData(User user) {
        System.out.println("+-----------------------+");
        System.out.println("| User Information      |");
        System.out.println("+-----------------------+");
        System.out.printf("| User ID: %-14s   |\n", user.getId());
        System.out.printf("| First Name: %-15s |\n", user.getFirstName());
        System.out.printf("| Last Name: %-16s |\n", user.getLastName());
        System.out.printf("| Email: %-20s |\n", user.getEmail());
        System.out.println("+-----------------------+");
    }



}
