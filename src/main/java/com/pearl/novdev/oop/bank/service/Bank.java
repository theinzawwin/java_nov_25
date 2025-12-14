package com.pearl.novdev.oop.bank.service;

import com.pearl.novdev.oop.bank.model.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    // Add new account
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added: " + account.getAccountId());
    }

    // Print all accounts
    public void listAccounts() {
        System.out.println("=== All Accounts ===");
        for (Account acc : accounts) {
            acc.printDetails();
            System.out.println("----------");
        }
    }

    // Find account by ID
    public Account findAccount(String accountId) {
        for (Account acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }
        return null;
    }

    // Apply monthly interest to all accounts
    public void applyMonthlyProcess() {
        System.out.println("=== Processing Monthly Interest ===");
        for (Account acc : accounts) {
            acc.applyMonthlyInterest();
            System.out.println("----------");
        }
    }
}
