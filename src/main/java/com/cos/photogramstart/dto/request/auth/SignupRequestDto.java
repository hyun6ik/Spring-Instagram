package com.cos.photogramstart.dto.request.auth;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String name;

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }
}
