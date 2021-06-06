package com.cos.photogramstart.service.user;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.dto.request.user.UserProfileDto;

public interface UserService {

    User updateUser(Long id, User user);

    UserProfileDto userProfile(Long userId, Long principalId);
}
