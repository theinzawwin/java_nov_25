package com.pearl.novdev.oop.noti;

public class PushNotification extends Notification{

    public PushNotification(String message){
        super(message);
        System.out.println("In Push NOti");
    }
    @Override
    public void send() {
        System.out.println("Sending Push Notification=>"+getMessage());
    }
}
