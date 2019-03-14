package com.stackroute.musicxapplication.exceptionAdvice;


import com.stackroute.musicxapplication.exceptions.TrackAlreadyExitsException;
import com.stackroute.musicxapplication.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler({TrackAlreadyExitsException.class, TrackNotFoundException.class})
    public ResponseEntity<?> handleTrackAlreadyExitsException(Exception e)
    {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
