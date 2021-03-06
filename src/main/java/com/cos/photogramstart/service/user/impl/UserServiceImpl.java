package com.cos.photogramstart.service.user.impl;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.dto.request.user.UserProfileDto;
import com.cos.photogramstart.exception.CustomException;
import com.cos.photogramstart.exception.CustomValidationApiException;
import com.cos.photogramstart.repository.SubScribeRepository;
import com.cos.photogramstart.repository.UserRepository;
import com.cos.photogramstart.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SubScribeRepository subScribeRepository;

    @Transactional
    @Override
    public User updateUser(Long id, User user) {
        //1 영속화
        User findUser = userRepository.findById(id).orElseThrow(() -> { return new CustomValidationApiException("찾을 수 없는 id입니다");});

        System.out.println("findUser.getId() = " + findUser.getId());
        findUser.setName(user.getName());
        findUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        findUser.setBio(user.getBio());
        findUser.setWebsite(user.getWebsite());
        findUser.setPhone(user.getPhone());
        findUser.setGender(user.getGender());
        //2 영속화된 오브젝트를 수정 - 더티체킹
        return findUser;
        //더티체킹 일어남
    }

    @Override
    public UserProfileDto userProfile(Long pageUserId, Long principalId) {
        //select * from Image where userId =:userId;
        User user = userRepository.findById(pageUserId).orElseThrow(() -> {
            throw new CustomException("해당 프로필 페이지는 없는 페이지입니다");
        });

        int subscribeState = subScribeRepository.mSubscribeState(principalId, pageUserId);
        int subscribeCount = subScribeRepository.mSubscribeCount(pageUserId);

        UserProfileDto dto = new UserProfileDto().builder()
                .user(user)
                .pageOwnerState(pageUserId == principalId)
                .imageCount(user.getImages().size())
                .subscribeCount(subscribeCount)
                .subscribeState(subscribeState == 1)
                .build();

        return dto;
    }
}

