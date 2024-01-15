package com.trainticket.TrainTicket;

import com.trainticket.models.*;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTicketAppServerTest {

    @Test
    void testPurchaseTicket() {
        TrainTicketAppServer server = new TrainTicketAppServer();

        PurchaseTicketRequest request = PurchaseTicketRequest.newBuilder()
                .setFrom("New York")
                .setTo("Los Angeles")
                .setUser(User.newBuilder()
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setEmail("johndoe@example.com")
                        .build())
                .build();

        StreamObserver<PurchaseTicketResponse> responseObserver = new StreamObserver<PurchaseTicketResponse>() {
            @Override
            public void onNext(PurchaseTicketResponse value) {
                assertNotNull(value.getReceipt());
                assertEquals(request.getFrom(), value.getReceipt().getFrom());
                assertEquals(request.getTo(), value.getReceipt().getTo());

                User requestUser = request.getUser();
                User responseUser = value.getReceipt().getUser();

                assertEquals(requestUser.getFirstName(), responseUser.getFirstName());
                assertEquals(requestUser.getLastName(), responseUser.getLastName());
                assertEquals(requestUser.getEmail(), responseUser.getEmail());
            }

            @Override
            public void onError(Throwable t) {
                fail("Error should not occur during purchaseTicket");
            }

            @Override
            public void onCompleted() {
                // Do nothing for this test
            }
        };

        server.purchaseTicket(request, responseObserver);
}
// Additional checks, if needed
// assertNotNull(response);


        @Test
    void testGetReceiptDetails() {
        TrainTicketAppServer server = new TrainTicketAppServer();

        PurchaseTicketRequest purchaseRequest = PurchaseTicketRequest.newBuilder()
                .setFrom("New York")
                .setTo("Los Angeles")
                .setUser(User.newBuilder()
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setEmail("johndoe@example.com")
                        .build())
                .build();

            StreamObserver<PurchaseTicketResponse> responseObserver = new StreamObserver<PurchaseTicketResponse>() {
            @Override
            public void onNext(PurchaseTicketResponse value) {
                String receiptID = value.getReceipt().getId();

                GetReceiptDetailsRequest detailsRequest = GetReceiptDetailsRequest.newBuilder()
                        .setReceiptID(receiptID)
                        .build();

                server.getReceiptDetails(detailsRequest, new StreamObserver<GetReceiptDetailsResponse>() {
                    @Override
                    public void onNext(GetReceiptDetailsResponse value) {
                        assertNotNull(value.getReceipt());
                        assertEquals(receiptID, value.getReceipt().getId());
                        assertEquals(purchaseRequest.getFrom(), value.getReceipt().getFrom());
                        assertEquals(purchaseRequest.getTo(), value.getReceipt().getTo());

                        User purchaseUser = purchaseRequest.getUser();
                        User detailsUser = value.getReceipt().getUser();

                        assertEquals(purchaseUser.getFirstName(), detailsUser.getFirstName());
                        assertEquals(purchaseUser.getLastName(), detailsUser.getLastName());
                        assertEquals(purchaseUser.getEmail(), detailsUser.getEmail());
                    }

                    @Override
                    public void onError(Throwable t) {
                        fail("Error should not occur during getReceiptDetails");
                    }

                    @Override
                    public void onCompleted() {
                        // Do nothing for this test
                    }
                });
            }

            @Override
            public void onError(Throwable t) {
                fail("Error should not occur during purchaseTicket");
            }

            @Override
            public void onCompleted() {
                // Do nothing for this test
            }
        };

        assertNotNull(responseObserver); // Optional: Additional checks if needed
    }
}
