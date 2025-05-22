package com.example.model;

import jakarta.persistence.*;

//Friend requests class that has sender and receiver (of class User) and the status of the request
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int r_id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private String r_status;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getR_status() {
        return r_status;
    }

    public void setR_status(String r_status) {
        this.r_status = r_status;
    }
}
