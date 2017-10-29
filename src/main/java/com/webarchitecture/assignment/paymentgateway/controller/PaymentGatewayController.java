package com.webarchitecture.assignment.paymentgateway.controller;

import com.webarchitecture.assignment.paymentgateway.model.PaymentInfo;
import com.webarchitecture.assignment.paymentgateway.repo.PaymentGatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentGatewayController {
    @Autowired
    private PaymentGatewayRepository repository;

    @RequestMapping(value = "makepayment", method = RequestMethod.POST)
    public ResponseEntity makePayment(@RequestBody PaymentInfo paymentInfo) {
        if (!repository.validateCreditCard(paymentInfo.getCreditCardNumber(), paymentInfo.getCvv())) {
            return ResponseEntity.badRequest().body("Invalid Credit Card details");
        }

        return ResponseEntity.ok("Payment Success");
    }
}
