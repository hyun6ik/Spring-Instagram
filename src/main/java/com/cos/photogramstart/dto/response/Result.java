package com.cos.photogramstart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T>{

    private int code; //1(성공), -1(실패)
    private String message;
    private T data;

//    public static <T> Result<T> success(T data){
//        return new Result(data);
//    }
//
//    public static <T> Result<T> error(T data){
//        return new Result(data);
//    }

}
