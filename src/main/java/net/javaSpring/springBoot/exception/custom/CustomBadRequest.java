package net.javaSpring.springBoot.exception.custom;

public class CustomBadRequest extends Exception {

    // Method costum exception - Bad request
    public CustomBadRequest(String message) {
        super(message);
    }
}
