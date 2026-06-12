package com.example.bank;

import java.util.ArrayList;

public class BankBranch {

    private ArrayList<BankAccount> allAccounts;

    public BankBranch() {
        this.allAccounts = new ArrayList<>();
    }

    public void openAccount(BankAccount account) {
        if (account != null) {
            allAccounts.add(account);
            System.out.println("Account " + account.getAccountNumber() + " successfully opened.");
        } else {
            System.out.println("Error: Account cannot be null.");
        }
    }

    public void closeAccount(String accNum) {
        BankAccount account = findAccount(accNum);

        if (account != null) {
            account.setActive(false);
            System.out.println("Account " + accNum + " has been closed (deactivated).");
        } else {
            System.out.println("Account not found with number: " + accNum);
        }
    }

    public BankAccount findAccount(String accNum) {
        for (BankAccount account : allAccounts) {
            if (account.getAccountNumber().equals(accNum)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<BankAccount> getVipAccounts(double minBalance) {
        ArrayList<BankAccount> vipAccounts = new ArrayList<>();

        for (BankAccount account : allAccounts) {
            if (account.getBalance() >= minBalance) {
                vipAccounts.add(account);
            }
        }
        return vipAccounts;
    }

    public ArrayList<String> getFrozenAccounts() {

        ArrayList<String> frozenAccountNumbers = new ArrayList<>();

        for (BankAccount account : allAccounts) {
            if (!account.isActive()) {
                frozenAccountNumbers.add(account.getAccountNumber());
            }
        }
        return frozenAccountNumbers;
    }

    public double calculateTotalBankLiquidity() {

        double totalLiquidity = 0.0;

        for (BankAccount account : allAccounts) {
            totalLiquidity += account.getBalance();
        }
        return totalLiquidity;
    }
}