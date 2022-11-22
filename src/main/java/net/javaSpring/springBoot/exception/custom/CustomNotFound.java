package net.javaSpring.springBoot.exception.custom;

public class CustomNotFound extends Exception {

    // Method costum exception - Not found
    public CustomNotFound(String message) {
        super(message);
    }
}
