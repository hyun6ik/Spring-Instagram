package com.cos.photogramstart.controller;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.dto.request.image.ImageUploadDto;
import com.cos.photogramstart.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping({"/", "/image/story"})
    public String story() {
        return "image/story";
    }

    @GetMapping("/image/popular")
    public String popular() {
        return "image/popular";
    }

    @GetMapping("/image/upload")
    public String uploadPage() {
        return "image/upload";
    }

    @PostMapping("/image")
    public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails) throws IOException {

        imageService.upload(imageUploadDto, principalDetails);

        return "redirect:/user/"+principalDetails.getUser().getId();
    }
}
