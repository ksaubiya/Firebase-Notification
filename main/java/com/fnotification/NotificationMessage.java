package com.fnotification;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class NotificationMessage {

    private String title;
    private String body;

    private List<String> token;


    public NotificationMessage(String recepientToken, String title, String body, List<String> token) {

        this.title = title;
        this.body = body;
        this.token = token;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public List<String> getToken() {
        return token;
    }

    public void setToken(List<String> token) {
        this.token = token;
    }
}
