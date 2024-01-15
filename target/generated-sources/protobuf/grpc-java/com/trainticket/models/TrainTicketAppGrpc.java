package com.trainticket.models;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: train-ticket-app.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TrainTicketAppGrpc {

  private TrainTicketAppGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TrainTicketApp";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.trainticket.models.PurchaseTicketRequest,
      com.trainticket.models.PurchaseTicketResponse> getPurchaseTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurchaseTicket",
      requestType = com.trainticket.models.PurchaseTicketRequest.class,
      responseType = com.trainticket.models.PurchaseTicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.trainticket.models.PurchaseTicketRequest,
      com.trainticket.models.PurchaseTicketResponse> getPurchaseTicketMethod() {
    io.grpc.MethodDescriptor<com.trainticket.models.PurchaseTicketRequest, com.trainticket.models.PurchaseTicketResponse> getPurchaseTicketMethod;
    if ((getPurchaseTicketMethod = TrainTicketAppGrpc.getPurchaseTicketMethod) == null) {
      synchronized (TrainTicketAppGrpc.class) {
        if ((getPurchaseTicketMethod = TrainTicketAppGrpc.getPurchaseTicketMethod) == null) {
          TrainTicketAppGrpc.getPurchaseTicketMethod = getPurchaseTicketMethod =
              io.grpc.MethodDescriptor.<com.trainticket.models.PurchaseTicketRequest, com.trainticket.models.PurchaseTicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurchaseTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.PurchaseTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.PurchaseTicketResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketAppMethodDescriptorSupplier("PurchaseTicket"))
              .build();
        }
      }
    }
    return getPurchaseTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.trainticket.models.GetReceiptDetailsRequest,
      com.trainticket.models.GetReceiptDetailsResponse> getGetReceiptDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReceiptDetails",
      requestType = com.trainticket.models.GetReceiptDetailsRequest.class,
      responseType = com.trainticket.models.GetReceiptDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.trainticket.models.GetReceiptDetailsRequest,
      com.trainticket.models.GetReceiptDetailsResponse> getGetReceiptDetailsMethod() {
    io.grpc.MethodDescriptor<com.trainticket.models.GetReceiptDetailsRequest, com.trainticket.models.GetReceiptDetailsResponse> getGetReceiptDetailsMethod;
    if ((getGetReceiptDetailsMethod = TrainTicketAppGrpc.getGetReceiptDetailsMethod) == null) {
      synchronized (TrainTicketAppGrpc.class) {
        if ((getGetReceiptDetailsMethod = TrainTicketAppGrpc.getGetReceiptDetailsMethod) == null) {
          TrainTicketAppGrpc.getGetReceiptDetailsMethod = getGetReceiptDetailsMethod =
              io.grpc.MethodDescriptor.<com.trainticket.models.GetReceiptDetailsRequest, com.trainticket.models.GetReceiptDetailsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReceiptDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.GetReceiptDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.GetReceiptDetailsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketAppMethodDescriptorSupplier("GetReceiptDetails"))
              .build();
        }
      }
    }
    return getGetReceiptDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.trainticket.models.GetUsersBySectionRequest,
      com.trainticket.models.GetUsersBySectionResponse> getGetUsersBySectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUsersBySection",
      requestType = com.trainticket.models.GetUsersBySectionRequest.class,
      responseType = com.trainticket.models.GetUsersBySectionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.trainticket.models.GetUsersBySectionRequest,
      com.trainticket.models.GetUsersBySectionResponse> getGetUsersBySectionMethod() {
    io.grpc.MethodDescriptor<com.trainticket.models.GetUsersBySectionRequest, com.trainticket.models.GetUsersBySectionResponse> getGetUsersBySectionMethod;
    if ((getGetUsersBySectionMethod = TrainTicketAppGrpc.getGetUsersBySectionMethod) == null) {
      synchronized (TrainTicketAppGrpc.class) {
        if ((getGetUsersBySectionMethod = TrainTicketAppGrpc.getGetUsersBySectionMethod) == null) {
          TrainTicketAppGrpc.getGetUsersBySectionMethod = getGetUsersBySectionMethod =
              io.grpc.MethodDescriptor.<com.trainticket.models.GetUsersBySectionRequest, com.trainticket.models.GetUsersBySectionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUsersBySection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.GetUsersBySectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.GetUsersBySectionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketAppMethodDescriptorSupplier("GetUsersBySection"))
              .build();
        }
      }
    }
    return getGetUsersBySectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.trainticket.models.RemoveUserRequest,
      com.trainticket.models.RemoveUserResponse> getRemoveUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveUser",
      requestType = com.trainticket.models.RemoveUserRequest.class,
      responseType = com.trainticket.models.RemoveUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.trainticket.models.RemoveUserRequest,
      com.trainticket.models.RemoveUserResponse> getRemoveUserMethod() {
    io.grpc.MethodDescriptor<com.trainticket.models.RemoveUserRequest, com.trainticket.models.RemoveUserResponse> getRemoveUserMethod;
    if ((getRemoveUserMethod = TrainTicketAppGrpc.getRemoveUserMethod) == null) {
      synchronized (TrainTicketAppGrpc.class) {
        if ((getRemoveUserMethod = TrainTicketAppGrpc.getRemoveUserMethod) == null) {
          TrainTicketAppGrpc.getRemoveUserMethod = getRemoveUserMethod =
              io.grpc.MethodDescriptor.<com.trainticket.models.RemoveUserRequest, com.trainticket.models.RemoveUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.RemoveUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.RemoveUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketAppMethodDescriptorSupplier("RemoveUser"))
              .build();
        }
      }
    }
    return getRemoveUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.trainticket.models.ModifyUserSeatRequest,
      com.trainticket.models.ModifyUserSeatResponse> getModifyUserSeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModifyUserSeat",
      requestType = com.trainticket.models.ModifyUserSeatRequest.class,
      responseType = com.trainticket.models.ModifyUserSeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.trainticket.models.ModifyUserSeatRequest,
      com.trainticket.models.ModifyUserSeatResponse> getModifyUserSeatMethod() {
    io.grpc.MethodDescriptor<com.trainticket.models.ModifyUserSeatRequest, com.trainticket.models.ModifyUserSeatResponse> getModifyUserSeatMethod;
    if ((getModifyUserSeatMethod = TrainTicketAppGrpc.getModifyUserSeatMethod) == null) {
      synchronized (TrainTicketAppGrpc.class) {
        if ((getModifyUserSeatMethod = TrainTicketAppGrpc.getModifyUserSeatMethod) == null) {
          TrainTicketAppGrpc.getModifyUserSeatMethod = getModifyUserSeatMethod =
              io.grpc.MethodDescriptor.<com.trainticket.models.ModifyUserSeatRequest, com.trainticket.models.ModifyUserSeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModifyUserSeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.ModifyUserSeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.trainticket.models.ModifyUserSeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TrainTicketAppMethodDescriptorSupplier("ModifyUserSeat"))
              .build();
        }
      }
    }
    return getModifyUserSeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrainTicketAppStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainTicketAppStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainTicketAppStub>() {
        @java.lang.Override
        public TrainTicketAppStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainTicketAppStub(channel, callOptions);
        }
      };
    return TrainTicketAppStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrainTicketAppBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainTicketAppBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainTicketAppBlockingStub>() {
        @java.lang.Override
        public TrainTicketAppBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainTicketAppBlockingStub(channel, callOptions);
        }
      };
    return TrainTicketAppBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrainTicketAppFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TrainTicketAppFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TrainTicketAppFutureStub>() {
        @java.lang.Override
        public TrainTicketAppFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TrainTicketAppFutureStub(channel, callOptions);
        }
      };
    return TrainTicketAppFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void purchaseTicket(com.trainticket.models.PurchaseTicketRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.PurchaseTicketResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPurchaseTicketMethod(), responseObserver);
    }

    /**
     */
    default void getReceiptDetails(com.trainticket.models.GetReceiptDetailsRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.GetReceiptDetailsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReceiptDetailsMethod(), responseObserver);
    }

    /**
     */
    default void getUsersBySection(com.trainticket.models.GetUsersBySectionRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.GetUsersBySectionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUsersBySectionMethod(), responseObserver);
    }

    /**
     */
    default void removeUser(com.trainticket.models.RemoveUserRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.RemoveUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveUserMethod(), responseObserver);
    }

    /**
     */
    default void modifyUserSeat(com.trainticket.models.ModifyUserSeatRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.ModifyUserSeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModifyUserSeatMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TrainTicketApp.
   */
  public static abstract class TrainTicketAppImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TrainTicketAppGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TrainTicketApp.
   */
  public static final class TrainTicketAppStub
      extends io.grpc.stub.AbstractAsyncStub<TrainTicketAppStub> {
    private TrainTicketAppStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainTicketAppStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainTicketAppStub(channel, callOptions);
    }

    /**
     */
    public void purchaseTicket(com.trainticket.models.PurchaseTicketRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.PurchaseTicketResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurchaseTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReceiptDetails(com.trainticket.models.GetReceiptDetailsRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.GetReceiptDetailsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReceiptDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUsersBySection(com.trainticket.models.GetUsersBySectionRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.GetUsersBySectionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUsersBySectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeUser(com.trainticket.models.RemoveUserRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.RemoveUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void modifyUserSeat(com.trainticket.models.ModifyUserSeatRequest request,
        io.grpc.stub.StreamObserver<com.trainticket.models.ModifyUserSeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModifyUserSeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TrainTicketApp.
   */
  public static final class TrainTicketAppBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TrainTicketAppBlockingStub> {
    private TrainTicketAppBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainTicketAppBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainTicketAppBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.trainticket.models.PurchaseTicketResponse purchaseTicket(com.trainticket.models.PurchaseTicketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurchaseTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.trainticket.models.GetReceiptDetailsResponse getReceiptDetails(com.trainticket.models.GetReceiptDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReceiptDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.trainticket.models.GetUsersBySectionResponse getUsersBySection(com.trainticket.models.GetUsersBySectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUsersBySectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.trainticket.models.RemoveUserResponse removeUser(com.trainticket.models.RemoveUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.trainticket.models.ModifyUserSeatResponse modifyUserSeat(com.trainticket.models.ModifyUserSeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModifyUserSeatMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TrainTicketApp.
   */
  public static final class TrainTicketAppFutureStub
      extends io.grpc.stub.AbstractFutureStub<TrainTicketAppFutureStub> {
    private TrainTicketAppFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainTicketAppFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TrainTicketAppFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.trainticket.models.PurchaseTicketResponse> purchaseTicket(
        com.trainticket.models.PurchaseTicketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurchaseTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.trainticket.models.GetReceiptDetailsResponse> getReceiptDetails(
        com.trainticket.models.GetReceiptDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReceiptDetailsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.trainticket.models.GetUsersBySectionResponse> getUsersBySection(
        com.trainticket.models.GetUsersBySectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUsersBySectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.trainticket.models.RemoveUserResponse> removeUser(
        com.trainticket.models.RemoveUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.trainticket.models.ModifyUserSeatResponse> modifyUserSeat(
        com.trainticket.models.ModifyUserSeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModifyUserSeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PURCHASE_TICKET = 0;
  private static final int METHODID_GET_RECEIPT_DETAILS = 1;
  private static final int METHODID_GET_USERS_BY_SECTION = 2;
  private static final int METHODID_REMOVE_USER = 3;
  private static final int METHODID_MODIFY_USER_SEAT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PURCHASE_TICKET:
          serviceImpl.purchaseTicket((com.trainticket.models.PurchaseTicketRequest) request,
              (io.grpc.stub.StreamObserver<com.trainticket.models.PurchaseTicketResponse>) responseObserver);
          break;
        case METHODID_GET_RECEIPT_DETAILS:
          serviceImpl.getReceiptDetails((com.trainticket.models.GetReceiptDetailsRequest) request,
              (io.grpc.stub.StreamObserver<com.trainticket.models.GetReceiptDetailsResponse>) responseObserver);
          break;
        case METHODID_GET_USERS_BY_SECTION:
          serviceImpl.getUsersBySection((com.trainticket.models.GetUsersBySectionRequest) request,
              (io.grpc.stub.StreamObserver<com.trainticket.models.GetUsersBySectionResponse>) responseObserver);
          break;
        case METHODID_REMOVE_USER:
          serviceImpl.removeUser((com.trainticket.models.RemoveUserRequest) request,
              (io.grpc.stub.StreamObserver<com.trainticket.models.RemoveUserResponse>) responseObserver);
          break;
        case METHODID_MODIFY_USER_SEAT:
          serviceImpl.modifyUserSeat((com.trainticket.models.ModifyUserSeatRequest) request,
              (io.grpc.stub.StreamObserver<com.trainticket.models.ModifyUserSeatResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPurchaseTicketMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.trainticket.models.PurchaseTicketRequest,
              com.trainticket.models.PurchaseTicketResponse>(
                service, METHODID_PURCHASE_TICKET)))
        .addMethod(
          getGetReceiptDetailsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.trainticket.models.GetReceiptDetailsRequest,
              com.trainticket.models.GetReceiptDetailsResponse>(
                service, METHODID_GET_RECEIPT_DETAILS)))
        .addMethod(
          getGetUsersBySectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.trainticket.models.GetUsersBySectionRequest,
              com.trainticket.models.GetUsersBySectionResponse>(
                service, METHODID_GET_USERS_BY_SECTION)))
        .addMethod(
          getRemoveUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.trainticket.models.RemoveUserRequest,
              com.trainticket.models.RemoveUserResponse>(
                service, METHODID_REMOVE_USER)))
        .addMethod(
          getModifyUserSeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.trainticket.models.ModifyUserSeatRequest,
              com.trainticket.models.ModifyUserSeatResponse>(
                service, METHODID_MODIFY_USER_SEAT)))
        .build();
  }

  private static abstract class TrainTicketAppBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrainTicketAppBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.trainticket.models.TrainTicketAppOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrainTicketApp");
    }
  }

  private static final class TrainTicketAppFileDescriptorSupplier
      extends TrainTicketAppBaseDescriptorSupplier {
    TrainTicketAppFileDescriptorSupplier() {}
  }

  private static final class TrainTicketAppMethodDescriptorSupplier
      extends TrainTicketAppBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TrainTicketAppMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrainTicketAppGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrainTicketAppFileDescriptorSupplier())
              .addMethod(getPurchaseTicketMethod())
              .addMethod(getGetReceiptDetailsMethod())
              .addMethod(getGetUsersBySectionMethod())
              .addMethod(getRemoveUserMethod())
              .addMethod(getModifyUserSeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
