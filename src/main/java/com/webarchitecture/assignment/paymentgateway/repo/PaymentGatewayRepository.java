package com.webarchitecture.assignment.paymentgateway.repo;

import com.webarchitecture.assignment.paymentgateway.model.PaymentInfo;

public interface PaymentGatewayRepository {
    boolean validateCreditCard(String creditCardNumber, int cvv);
    int saveTransaction(PaymentInfo paymentInfo);
    boolean validateTransaction(int code);
}
