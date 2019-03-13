package com.stackroute.musicxapplication.exceptions;

public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
