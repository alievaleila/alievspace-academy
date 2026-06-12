package com.example.bank;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== 1. Bank Branch is Launching ===");
        BankBranch bakuBranch = new BankBranch();

        System.out.println("\n=== 2. Opening New Accounts ===");

        BankAccount standardAcc = new BankAccount("AZ01A", "Anar Aliyev", 500.0);


        CreditAccount creditAcc = new CreditAccount("AZ02C", "Banu Mammadova", 200.0,
                1000.0, 0.12);

        bakuBranch.openAccount(standardAcc);
        bakuBranch.openAccount(creditAcc);

        System.out.println("\n=== 3. Shopping and Cashback Mechanism ===");

        standardAcc.withdraw(100.0, "Supermarket");

        standardAcc.withdraw(50.0, "Restaurant");

        System.out.println("Anar's current cashback balance: " + standardAcc.getCashbackBalance() + " AZN");


        System.out.println("Anar is transferring cashback to main balance...");
        standardAcc.claimCashback();
        System.out.println("Anar's new main balance: " + standardAcc.getBalance() + " AZN");

        System.out.println("\n=== 4. Withdrawing from Credit Account via Limit ===");

        System.out.println("Banu wants to withdraw 500 AZN (Balance: " + creditAcc.getBalance() + " AZN)...");
        creditAcc.withdraw(500.0);

        System.out.println("\n=== 5. Taking a Term Loan ===");

        creditAcc.takeLoan(400.0, 6);

        System.out.println("\n=== 6. Money Transfer Between Accounts ===");


        System.out.println("Anar is sending 150 AZN to Banu...");
        boolean successfulTransfer = standardAcc.transferMoney(creditAcc, 150.0);

        if (successfulTransfer) {
            System.out.println("After transfer - Anar's balance: " + standardAcc.getBalance() + " AZN");
            System.out.println("After transfer - Banu's balance: " + creditAcc.getBalance() + " AZN");
        }


        System.out.println("\n=== 7. Central System Analytics ===");

        System.out.println("Searching for account number AZ01A in the system...");
        BankAccount foundAcc = bakuBranch.findAccount("AZ01A");
        if (foundAcc != null) {
            System.out.println("Account found! Holder's name: " + foundAcc.getHolderName());
        }

        System.out.println("\nListing VIP customers (Balance >= 300 AZN):");
        ArrayList<BankAccount> vips = bakuBranch.getVipAccounts(300.0);
        for (BankAccount vip : vips) {
            System.out.println("- " + vip.getHolderName() + " (Balans: " + vip.getBalance() + " AZN)");
        }

        double totalBankLiquidity = bakuBranch.calculateTotalBankLiquidity();
        System.out.println("\nTotal bank liquidity (Sum of all balances): " + totalBankLiquidity + " AZN");

        System.out.println("\nClosing Anar's account (Deactivating)...");
        bakuBranch.closeAccount("AZ01A");

        ArrayList<String> frozenAccounts = bakuBranch.getFrozenAccounts();
        System.out.println("List of frozen accounts: " + frozenAccounts);
    }
}