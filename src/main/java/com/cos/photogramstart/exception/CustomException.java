package com.cos.photogramstart.exception;

import java.util.Map;


public class CustomException extends RuntimeException {

    //객체를 구분할 때
    private static final long serialVersionUID = 1L;

    private String message;
    private Map<String, String> errorMap;

    public CustomException(String message) {
        this.message =message;
    }

    public CustomException(String message, Map<String, String> errorMap) {
        this.message = message;
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
