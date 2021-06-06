package com.cos.photogramstart.service.image;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.dto.request.image.ImageUploadDto;

import java.io.IOException;

public interface ImageService {

    void upload(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) throws IOException;

}
