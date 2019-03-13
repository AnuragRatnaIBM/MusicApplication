package com.stackroute.musicxapplication.exceptions;

public class TrackAlreadyExitsException extends Exception {
    private String message;

    public TrackAlreadyExitsException(String message) {
        super(message);
        this.message = message;
    }
}
