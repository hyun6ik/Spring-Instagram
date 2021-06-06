package com.cos.photogramstart.dto.request.image;

import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageUploadDto {

    private MultipartFile file;
    private String caption;


    public Image toEntity(String postImageUrl, User user){
        return Image.builder()
                .caption(caption)
                .postImageUrl(postImageUrl)
                .user(user)
                .build();
    }
}
