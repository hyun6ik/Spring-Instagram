package com.cos.photogramstart.service.auth.impl;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.repository.UserRepository;
import com.cos.photogramstart.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional //Write Update Delete
    @Override
    public User createUser(User user) {

        String encPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encPassword);
        user.setRole("ROLE_USER");
        return userRepository.save(user);

    }
}
