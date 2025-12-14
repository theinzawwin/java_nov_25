package com.pearl.novdev.oop.noti;

public class SlackNotification extends Notification{

    public SlackNotification(String message){
        super(message);
        System.out.println("In Slack Noti");
    }
    public void showMessage(){
        System.out.println("Showing message "+getMessage());
    }
}
