package com.example.paymentsystem;

class CreditCardPayment implements Payable, Refundable {

    private double amount;

    public CreditCardPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateAmount() {
        return amount;
    }

    @Override
    public boolean isRefundable() {
        return true;
    }
}
