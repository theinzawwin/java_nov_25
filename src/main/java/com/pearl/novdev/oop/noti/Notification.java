package com.pearl.novdev.oop.noti;

public class Notification {

    private String message;

    public Notification(String message){
        System.out.println("Initialize in Notification");
        this.message = message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    protected String capitalizeMessage(String message){
        return message.toUpperCase();
    }


    public void send(){
        System.out.println("Sending notification....");
    }

    public static void sendNow(){
        System.out.println("Send Now using Static");
    }
}
