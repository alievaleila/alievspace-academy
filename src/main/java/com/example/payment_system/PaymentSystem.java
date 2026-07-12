package com.example.payment_system;

public class PaymentSystem {
    public static void main(String[] args) {

        CreditCardPayment card = new CreditCardPayment(250.0);
        CashPayment cash = new CashPayment(50.0);

        card.printReceipt();

        if (card.isRefundable()) {
            System.out.println("This payment is refundable.");
        } else {
            System.out.println("This payment is not refundable.");
        }

        System.out.println("-------------------------");

        cash.printReceipt();
        if (cash.isRefundable()) {
            System.out.println("This payment is refundable.");
        } else {
            System.out.println("This payment is not refundable.");
        }
    }
}