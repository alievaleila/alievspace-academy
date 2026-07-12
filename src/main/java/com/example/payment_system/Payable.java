package com.example.payment_system;

public interface Payable {

    double calculateAmount();

    default void printReceipt(){

        System.out.println("Payment amount: " + calculateAmount());
    }
}
