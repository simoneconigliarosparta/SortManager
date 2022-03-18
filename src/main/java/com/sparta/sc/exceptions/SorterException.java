package com.sparta.sc.exceptions;

public class SorterException extends Exception {

    @Override
    public String getMessage() {
        return "The sorter selected is invalid";
    }
}
