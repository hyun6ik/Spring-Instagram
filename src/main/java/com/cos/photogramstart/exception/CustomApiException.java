package com.cos.photogramstart.exception;

import java.util.Map;


public class CustomApiException extends RuntimeException {

    //객체를 구분할 때
    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMap;

    public CustomApiException(String message) {
        super(message);
    }

    public CustomApiException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

    public Map<String,String> getErrorMap(){
        return errorMap;
    }
}
