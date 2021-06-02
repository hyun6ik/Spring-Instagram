package com.cos.photogramstart.controller;

import com.cos.photogramstart.repository.user.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user/{id}")
    public String profilePage(@PathVariable("id") Long id) {
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String updatePage(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails = " + principalDetails.toString());

        return "user/update";
    }
}
