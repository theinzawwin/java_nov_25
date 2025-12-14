package com.pearl.novdev.oop.encapsulation;

public class Customer {
        private String name;
        private String email;
        private int age;

        // Constructor
        public Customer(String name, String email, int age) {
            this.name = name;
            setEmail(email); // Using setter in constructor
            setAge(age);     // Using setter in constructor
        }

        // Getter and Setter methods (encapsulation)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name != null && !name.trim().isEmpty()) {
                this.name = name;
            }
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            // Validation
            if (email != null && email.contains("@")) {
                this.email = email;
            } else {
                System.out.println("Invalid email address!");
            }
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            // Validation
            if (age >= 18 && age <= 100) {
                this.age = age;
            } else {
                System.out.println("Age must be between 18 and 100!");
            }
        }

        public void displayInfo() {
            System.out.println("Customer: " + name + ", Email: " + email + ", Age: " + age);
        }
}
