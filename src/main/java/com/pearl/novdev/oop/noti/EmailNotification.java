package com.pearl.novdev.oop.noti;

public class EmailNotification extends Notification{

    public EmailNotification(String message){
        super(message);
        System.out.println("In Email Noti");
    }
    @Override
    public void send() {
        System.out.println("Sending Email.."+getMessage());
    }
}
