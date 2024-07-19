package com.example.chatapp.model;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ChatMessage {
    String senderID;
    String text;
    long time;
    boolean isMine;

    public ChatMessage(String senderID, String text, long time) {
        this.senderID = senderID;
        this.text = text;
        this.time = time;



    }

    public ChatMessage() {
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isMine() {
        if(senderID.equals(FirebaseAuth.getInstance().getCurrentUser().getUid()))
        {
            return true;
        }
        return false;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }


    public String convertTime()
    {
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        Date date=new Date(getTime());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }
}
