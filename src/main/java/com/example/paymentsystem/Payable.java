package com.example.paymentsystem;

public interface Payable {

    double calculateAmount();

    default void printReceipt(){

        System.out.println("Payment amount: " + calculateAmount());
    }
}
