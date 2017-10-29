package com.webarchitecture.assignment.paymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentGatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(PaymentGatewayServer.class, args);
    }
}
