package com.cos.photogramstart.controller.api;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.dto.request.user.UserUpdateRequestDto;
import com.cos.photogramstart.dto.response.Result;
import com.cos.photogramstart.repository.user.PrincipalDetails;
import com.cos.photogramstart.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public Result<?> update(@PathVariable("id") Long id, UserUpdateRequestDto userUpdateRequestDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = userService.updateUser(id, userUpdateRequestDto.toEntity());
        principalDetails.setUser(user);
        return new Result<>(1, "회원수정완료",user);

    }
}
