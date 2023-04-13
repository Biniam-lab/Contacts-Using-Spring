package com.mydemoproject.contacts.error;

public class ContactNotFoundException extends Exception{
    public ContactNotFoundException() {
        super();
    }

    public ContactNotFoundException(String message) {
        super(message);
    }
}
