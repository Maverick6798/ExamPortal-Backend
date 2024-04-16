package com.self.ExamPortal.exceptionHandling;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User with this username not found");
    }
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
