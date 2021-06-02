package com.cos.photogramstart.handler;

import com.cos.photogramstart.dto.response.Result;
import com.cos.photogramstart.exception.CustomValidationException;
import com.cos.photogramstart.util.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){
        return Script.back(e.getErrorMap().toString());
    }
}
