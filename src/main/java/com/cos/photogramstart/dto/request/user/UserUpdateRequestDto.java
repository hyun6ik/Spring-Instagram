package com.cos.photogramstart.dto.request.user;

import com.cos.photogramstart.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String name;   //필수
    private String password;  //필수
    private String website;
    private String bio;
    private String phone;
    private String gender;


    //위험함 코드수정 필요
    public User toEntity(){
        return User.builder()
                .name(name)             //이름 필수 Validation Check!
                .password(password)   //패스워드 기재 안했으면 공백패스워드 들어감 위험!! Validation Check
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }
}
