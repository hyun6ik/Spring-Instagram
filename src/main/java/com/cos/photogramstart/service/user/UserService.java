package com.cos.photogramstart.service.user;

import com.cos.photogramstart.domain.user.User;

public interface UserService {

    User updateUser(Long id, User user);
}
