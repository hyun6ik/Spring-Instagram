package com.cos.photogramstart.controller;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public String profilePage(@PathVariable("id") Long id, Model model) {
        User user = userService.userProfile(id);
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String updatePage(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails = " + principalDetails.toString());

        return "user/update";
    }
}
