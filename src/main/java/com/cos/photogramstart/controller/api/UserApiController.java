package com.cos.photogramstart.controller.api;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.dto.request.user.UserUpdateRequestDto;
import com.cos.photogramstart.dto.response.Result;
import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.exception.CustomValidationApiException;
import com.cos.photogramstart.exception.CustomValidationException;
import com.cos.photogramstart.service.subscribe.SubScribeService;
import com.cos.photogramstart.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final SubScribeService subScribeService;

    @PutMapping("/api/user/{id}")
    public Result<?> update(@PathVariable("id") Long id, @Valid UserUpdateRequestDto userUpdateRequestDto, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails){

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationApiException("유효성 검사 실패", errorMap);
        } else {
            User user = userService.updateUser(id, userUpdateRequestDto.toEntity());
            principalDetails.setUser(user);
            return new Result<>(1, "회원수정완료", user); //응답시에 user의 모든 Getter가 호출되고 JSON으로 파싱하여 응답한다.
        }
    }

    @GetMapping("/api/user/{pageUserId}/subscribe")
    public ResponseEntity<?> subscribeList(@PathVariable Long pageUserId, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        subScribeService.subscribeList(principalDetails.getUser().getId(), pageUserId);

        return new ResponseEntity<>(new Result<>(1,"구독자 정보 리스트 가져오기 성공", subScribeDto), HttpStatus.OK);
    }
}
