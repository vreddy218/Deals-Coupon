package com.example.demo;

public class HelloWorld {
	public String message;

    public HelloWorld(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorld[message=%s]",message);
    }
}
