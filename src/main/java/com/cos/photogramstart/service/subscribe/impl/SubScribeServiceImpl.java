package com.cos.photogramstart.service.subscribe.impl;

import com.cos.photogramstart.repository.subscribe.SubScribeRepository;
import com.cos.photogramstart.service.subscribe.SubScribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("subScribeService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubScribeServiceImpl implements SubScribeService {

    private final SubScribeRepository subScribeRepository;

    @Transactional
    @Override
    public void subscribe(Long fromUserId, Long toUserId ) {
        subScribeRepository.mSubscribe(fromUserId, toUserId);

    }

    @Transactional
    @Override
    public void unSubscribe(Long fromUserId, Long toUserId) {
        subScribeRepository.mUnSubscribe(fromUserId, toUserId);

    }
}
