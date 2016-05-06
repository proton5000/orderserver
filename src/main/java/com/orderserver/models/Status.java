package com.orderserver.models;

/**
 * Created by proton on 29.01.2016.
 */
public class Status {

    private String error;

    private String message;

    public String getError() {
        return error;
    }

    public Status setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Status setMessage(String errorMessage) {
        this.message = errorMessage;
        return this;
    }
}
