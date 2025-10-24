package com.example.Customizexception;

public class ResponseWrapper<T> {

    private String errormessage;
    private T data;

    public ResponseWrapper(String message, T data) {
        this.errormessage = message;
        this.data = data;
    }

    public String getMessage() {
        return errormessage;
    }

    public void setMessage(String message) {
        this.errormessage = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
