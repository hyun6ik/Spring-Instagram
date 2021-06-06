package com.cos.photogramstart.service.image.impl;

import com.cos.photogramstart.service.image.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("imageService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {
}
