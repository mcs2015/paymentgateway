package com.webarchitecture.assignment.paymentgateway.repo;

import com.webarchitecture.assignment.paymentgateway.model.CreditCard;
import com.webarchitecture.assignment.paymentgateway.model.PaymentInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class PaymentGatewayRepositoryImpl implements PaymentGatewayRepository {
    private static final String CREDIT_CARD_NUMBER = "4111111111111111";
    private static Map<String, CreditCard> creditCards = new HashMap<String, CreditCard>();
    private Map<String, PaymentInfo> transactions = new HashMap<String, PaymentInfo>();

    public PaymentGatewayRepositoryImpl() {
        creditCards.put(CREDIT_CARD_NUMBER, new CreditCard(CREDIT_CARD_NUMBER, 123));
    }

    @Override
    public boolean validateCreditCard(String creditCardNumber, int cvv) {
        if (creditCards.containsKey(creditCardNumber) && creditCards.get(creditCardNumber).getCvv() == cvv) {
            return true;
        }
        return false;
    }

    @Override
    public int saveTransaction(PaymentInfo paymentInfo) {
        Random random = new Random();
        int code = random.nextInt(1000) + 1000;
        transactions.put(String.valueOf(code), paymentInfo);
        return code;
    }

    @Override
    public boolean validateTransaction(int code) {
        if (transactions.containsKey(String.valueOf(code))) {
            transactions.remove(String.valueOf(code));
            return true;
        }
        return false;
    }
}
