package com.cos.photogramstart.controller.api;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.dto.response.Result;
import com.cos.photogramstart.service.subscribe.SubScribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubScribeApiController {

    private final SubScribeService subScribeService;

    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("toUserId") Long toUserId) {
        subScribeService.subscribe(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(new Result<>(1, "구독하기 성공", null), HttpStatus.OK);
    }

    @DeleteMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unsubScribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable("toUserId") Long toUserId){
        subScribeService.unSubscribe(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(new Result<>(1, "구독취소하기 성공", null), HttpStatus.OK);

    }
}
