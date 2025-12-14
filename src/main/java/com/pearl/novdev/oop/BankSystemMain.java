package com.pearl.novdev.oop;

import com.pearl.novdev.oop.abstraction.FixedDepositAccount;
import com.pearl.novdev.oop.encapsulation.Customer;

public class BankSystemMain {

    public static void main(String[] args) {
        System.out.println("=== BANK ACCOUNT SYSTEM ===\n");

        // Creating objects
        BankAccount account1 = new BankAccount("ACC001", "John Doe", 1000);
        SavingsAccount savings = new SavingsAccount("SAV001", "Jane Smith", 5000, 2.5);
        CheckingAccount checking = new CheckingAccount("CHK001", "Bob Johnson", 2000, 500);
        Customer customer = new Customer("Alice Brown", "alice@email.com", 25);

        // Testing BankAccount
        System.out.println("1. Regular Bank Account:");
        account1.deposit(500);
        account1.withdraw(200);
        account1.displayBalance();

        System.out.println("\n2. Savings Account:");
        savings.displayBalance();
        savings.applyInterest();
        savings.displayBalance();

        System.out.println("\n3. Checking Account (with overdraft):");
        checking.displayBalance();
        checking.withdraw(2400); // Within overdraft limit
        checking.displayBalance();

        System.out.println("\n4. Customer Information:");
        customer.displayInfo();

        // Testing encapsulation
        System.out.println("\n5. Testing Encapsulation:");
        customer.setEmail("invalid-email"); // Should show error
        customer.setAge(17); // Should show error
        customer.setEmail("valid@email.com");
        customer.setAge(30);
        customer.displayInfo();

        // Testing abstraction
        System.out.println("\n6. Testing Abstraction:");
        FixedDepositAccount fd = new FixedDepositAccount("FD001", 10000, 5.0, 12);
        fd.displayAccountInfo();
        fd.calculateInterest();

        // Polymorphism example
        System.out.println("\n7. Polymorphism Example:");
        BankAccount[] accounts = {account1, savings, checking};

        for (BankAccount account : accounts) {
            System.out.println("--- Processing Account ---");
            account.displayBalance();
            System.out.println("Account Type: " + account.getClass().getSimpleName());
            System.out.println();
        }
    }
}
