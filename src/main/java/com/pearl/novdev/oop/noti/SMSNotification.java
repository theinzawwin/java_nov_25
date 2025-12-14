package com.pearl.novdev.oop.noti;

public class SMSNotification extends Notification{

    public SMSNotification(String message){
        super(message);
        System.out.println("In Slack Noti");
    }
    @Override
    public void send() {
        System.out.println("Sending SMS...");
    }
}
