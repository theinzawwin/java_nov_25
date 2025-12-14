package com.pearl.novdev.oop.bank;

import com.pearl.novdev.oop.bank.model.CurrentAccount;
import com.pearl.novdev.oop.bank.model.SavingAccount;
import com.pearl.novdev.oop.bank.service.Bank;

public class BankMain {
    public static void main(String[] args) {

        Bank bank = new Bank();

        // Create accounts
        SavingAccount s1 = new SavingAccount("S001", 1000, 0.03);
        SavingAccount s2 = new SavingAccount("S002", 2000, 0.04);

        CurrentAccount c1 = new CurrentAccount("C001", 500, 300);
        CurrentAccount c2 = new CurrentAccount("C002", 1000, 500);

        // Add accounts to bank
        bank.addAccount(s1);
        bank.addAccount(s2);
        bank.addAccount(c1);
        bank.addAccount(c2);

        System.out.println();
        bank.listAccounts();

        System.out.println("\n--- Transactions ---");
        s1.deposit(300);
        s1.withdraw(200);

        c1.withdraw(700); // within overdraft
        c1.withdraw(300); // exceeds overdraft

        System.out.println();
        bank.applyMonthlyProcess();

        System.out.println();
        bank.listAccounts();
    }
}
