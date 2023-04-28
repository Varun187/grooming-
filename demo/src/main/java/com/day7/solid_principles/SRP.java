package com.day7.solid_principles;

//Single Responsibility Principle 

// Customer class is responsible only for storing and managing customer data, such as name, email, and address.
class Customer {
    private String name;
    private String email;
    private String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

// The EmailSender class is responsible only for sending emails
class EmailSender {
    public void sendEmail(Customer customer, String message) {
        System.out.println(customer.getName() + " email is sent to " + customer.getEmail());
        System.out.println(message);
    }
}

// PaymentProcessor class is responsible only for processing payments.

class PaymentProcessor {
    public void processPayment(Customer customer, double amount) {
        System.out.println(customer.getName() + " amount is added " + amount);
    }
}

// Each class has a single responsibility, making the code more modular, easier
// to test, and easier to maintain.
public class SRP {
    public static void main(String[] args) {
        Customer customer = new Customer("Varun", "varun@email.com", "Coimbatore");
        EmailSender emailSender = new EmailSender();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        emailSender.sendEmail(customer, "Thank you for your purchase!");
        paymentProcessor.processPayment(customer, 100.00);
    }
}
