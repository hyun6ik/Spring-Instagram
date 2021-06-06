package com.cos.photogramstart.controller;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.dto.request.auth.SignupRequestDto;
import com.cos.photogramstart.exception.CustomValidationException;
import com.cos.photogramstart.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/signin")
    public String signInForm(){
        return "auth/signin";
    }

    @GetMapping("/signup")
    public String signUpForm(){
        return "auth/signup";
    }

    //회원가입버튼 -> /auth/signup -> /auth/signin
    @PostMapping("/signup")
    public String signUp(@Valid SignupRequestDto requestDto, BindingResult bindingResult) { // key = value(x-www-form-urlencoded)

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패", errorMap);
        } else {

            User user = requestDto.toEntity();
            authService.createUser(user);
            return "auth/signin";
        }
    }


}
