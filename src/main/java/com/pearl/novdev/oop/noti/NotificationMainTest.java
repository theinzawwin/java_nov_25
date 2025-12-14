package com.pearl.novdev.oop.noti;

public class NotificationMainTest {

    public static void main(String[] args){

        Notification n = new Notification("Send Noti");

       Notification[] notifications = {
               new EmailNotification("Email Noti Message"),
               new PushNotification("Push Noti Message"),
               new SMSNotification("SMS Noti Message"),
               new SlackNotification("Slack Noti Message")
       };

       for(Notification noti : notifications){
           noti.send();
       }

    }
}
