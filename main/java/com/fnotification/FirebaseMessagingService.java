package com.fnotification;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }


//    public String sendNotificationByToken(NotificationMessage notificationMessage){
//
//        Notification notification = Notification
//                .builder()
//                .setTitle(notificationMessage.getTitle())
//                .setBody(notificationMessage.getBody())
//                .build();
//
//        Message message = Message
//                .builder()
//                .setToken(notificationMessage.getRecepientToken())
//                .setNotification(notification)
//                .putAllData(notificationMessage.getData())
//                .build();
//        try{
//            firebaseMessaging.send(message);
//            return "successfully send notification";
//        }
//        catch (FirebaseMessagingException e)
//        {
//            e.printStackTrace();
//            return "Error sending";
//        }
//
//
//    }

    public String sendNotificationByTokens(NotificationMessage notificationMessage) {
        Notification notification = Notification
                .builder()
                .setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody())
                .build();

        List<Message> messages = new ArrayList<>();

        for (String token : notificationMessage.getToken()) {
            Message message = Message
                    .builder()
                    .setToken(token)
                    .setNotification(notification)
                    .build();
            messages.add(message);
        }

        try {
            BatchResponse batchResponse = firebaseMessaging.sendAll(messages);
            // Process the batch response if needed
            return "Successfully sent notifications";
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return "Error sending notifications";
        }
    }
}
