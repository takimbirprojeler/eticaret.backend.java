package com.example.User;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.User.service.UserGrpcServiceImp;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(UserApplication.class, args);
		Server server = ServerBuilder
			.forPort (8081)
			.addService (new UserGrpcServiceImp ()).build ();
			server.start ();
			server.awaitTermination();
	}

	@Bean
	public GrpcServerConfigurer keepAliveServerConfigurer() {
		return serverBuilder -> {
			if (serverBuilder instanceof NettyServerBuilder) {
				((NettyServerBuilder) serverBuilder).keepAliveTime(30, TimeUnit.SECONDS)
						.keepAliveTimeout(5, TimeUnit.SECONDS).permitKeepAliveWithoutCalls(true);
			}
		};
	}

}
