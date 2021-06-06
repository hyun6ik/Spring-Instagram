package com.cos.photogramstart.handler;

import com.cos.photogramstart.dto.response.Result;
import com.cos.photogramstart.exception.CustomApiException;
import com.cos.photogramstart.exception.CustomValidationApiException;
import com.cos.photogramstart.exception.CustomValidationException;
import com.cos.photogramstart.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){
        if (e.getErrorMap() == null) {
            return Script.back(e.getMessage());
        } else {
            return Script.back(e.getErrorMap().toString());
        }
    }

    @ExceptionHandler(CustomValidationApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<?> validationException(CustomValidationApiException e){
        return new Result<>(-1, e.getMessage(), e.getErrorMap());
    }

    @ExceptionHandler(CustomApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<?> validationException(CustomApiException e){
        return new Result<>(-1, e.getMessage(), null);
    }
}
