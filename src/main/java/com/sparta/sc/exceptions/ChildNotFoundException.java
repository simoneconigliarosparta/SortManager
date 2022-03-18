package com.sparta.sc.exceptions;

public class ChildNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "The child requested cannot be found in the binary tree";
    }
}
