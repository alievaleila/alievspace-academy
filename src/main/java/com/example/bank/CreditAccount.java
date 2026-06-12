package com.example.bank;

public class CreditAccount extends BankAccount {

    private double creditLimit;
    private double interestRate;

    public CreditAccount(String accountNumber, String holderName, double balance, double creditLimit, double interestRate) {
        super(accountNumber, holderName, balance);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {

        if (!isActive()) {
            System.out.println("Account is not active.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }

        double currentBalance = getBalance();

        if (amount > (currentBalance + this.creditLimit)) {
            System.out.println("Transaction was rejected. Insufficient funds (Even with credit limit).");
            return false;
        }

        if (currentBalance >= amount) {
            return super.withdraw(amount);
        } else {
            double missingAmount = amount - currentBalance;

            if (currentBalance > 0) {
                super.withdraw(currentBalance);
            }

            this.creditLimit -= missingAmount;

            System.out.println("Credit limit used: " + missingAmount + " AZN. Remaining credit limit: " + this.creditLimit);
            System.out.println("Account balance is now 0.0 AZN.");
            return true;
        }
    }

    public void takeLoan(double amount) {
        if (!isActive()) {
            System.out.println("Loan rejected: Account is inactive.");
            return;
        }

        if (amount > 0 && amount <= this.creditLimit) {
            this.creditLimit -= amount;
            deposit(amount);
            System.out.println("Simple loan approved: " + amount + " AZN added to balance.");
        } else {
            System.out.println("Loan rejected: Amount exceeds your credit limit or invalid amount.");
        }
    }

    public void takeLoan(double amount, int months) {
        if (!isActive()) {
            System.out.println("Loan rejected: Account is inactive.");
            return;
        }

        if (amount <= 0 || months <= 0) {
            System.out.println("Loan rejected: Invalid amount or month duration.");
            return;
        }

        if (amount <= this.creditLimit) {
            this.creditLimit -= amount;

            double totalDebt = amount * (1 + (this.interestRate * (months / 12.0)));
            double monthlyPayment = totalDebt / months;

            deposit(amount);

            System.out.println("Term loan approved: " + amount + " AZN added to balance.");
            System.out.println("Total debt to repay: " + totalDebt + " AZN for " + months + " months.");
            System.out.println("Estimated monthly payment: " + String.format("%.2f", monthlyPayment) + " AZN.");
        } else {
            System.out.println("Loan rejected: Amount exceeds your credit limit.");
        }
    }
}

