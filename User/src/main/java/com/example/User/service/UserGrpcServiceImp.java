package com.example.User.service;

import com.example.user.HelloRequest;
import com.example.user.HelloResponse;
import com.example.user.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserGrpcServiceImp extends HelloServiceImplBase  {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    

        responseObserver.onNext(
            HelloResponse.newBuilder().setGreeting("Hello World " + request.getFirstName() ).build()
        );
        responseObserver.onCompleted();
    }
    
    
}
