package com.example.AIBooks.errorException;

public class NotAuthorizedException extends RuntimeException  {
    public NotAuthorizedException(String message) {
        super(message);
    }
}
