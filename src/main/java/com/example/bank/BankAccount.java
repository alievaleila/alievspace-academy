package com.example.bank;

public class BankAccount {

    private final String accountNumber;
    private String holderName;
    private double balance;
    private boolean isActive;
    private double cashbackBalance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.isActive = true;
        this.cashbackBalance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public double getCashbackBalance() {
        return cashbackBalance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void deposit(double amount) {

        if (isActive && amount > 0) {
            this.balance += amount;
            System.out.println("Deposited " + amount + " to account " + this.accountNumber + ". Current balance: " + this.balance);
        } else {
            System.out.println("Transaction was rejected. Inactive account or invalid amount");
        }
    }

    public boolean withdraw(double amount) {

        if (!isActive) {
            System.out.println("Operation was rejected. Inactive account.");
            return false;
        }
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println(amount + " AZN was withdrawn from the account. Current balance: " + this.balance);
            return true;
        } else {
            System.out.println("Transaction was rejected. Insufficient funds.");
            return false;
        }
    }

    public boolean withdraw(double amount, String category) {

        boolean isSuccess = withdraw(amount);

        if (isSuccess && category != null) {
            double cashback = 0.0;

            if (category.equalsIgnoreCase("Supermarket")) {
                cashback = amount * 0.01;
            } else if (category.equalsIgnoreCase("Restaurant")) {
                cashback = amount * 0.02;
            }

            if (cashback > 0) {
                this.cashbackBalance += cashback;
                System.out.println("For " + category + " category, " + cashback + " AZN cashback was gained.");
            }
        }
        return isSuccess;
    }

    public void claimCashback() {

        if (isActive && this.cashbackBalance > 0) {
            double tempCashback = this.cashbackBalance;
            this.balance += tempCashback;
            this.cashbackBalance = 0;
            System.out.println(tempCashback + " AZN cashback was claimed. New balance: " + this.balance);
        } else {
            System.out.println("There is no cashback or inactive account.");
        }
    }

    public boolean transferMoney(BankAccount targetAccount, double amount) {

        if (!this.isActive) {
            System.out.println("Operation was rejected. Inactive account.");
            return false;
        }

        if (targetAccount == null || !targetAccount.isActive()) {
            System.out.println("Transfer failed: Recipient account not found or inactive.");
            return false;
        }

        if (amount < 0) {
            System.out.println("Transfer failed: Negative amount.");
            return false;
        }

        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            System.out.println("Successful Transfer: " + amount + " AZN has been transferred to the account of "
                    + targetAccount.getHolderName() + ".");
            return true;
        } else {
            System.out.println("Transfer failed: Insufficient funds.");
            return false;
        }
    }
}
