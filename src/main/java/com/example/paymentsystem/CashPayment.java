package com.example.paymentsystem;

class CashPayment implements Payable, Refundable {

    private double amount;

    public CashPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateAmount() {
        return amount;
    }

    @Override
    public boolean isRefundable() {
        return false;
    }
}