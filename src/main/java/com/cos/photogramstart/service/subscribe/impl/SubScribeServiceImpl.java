package com.cos.photogramstart.service.subscribe.impl;

import com.cos.photogramstart.dto.response.subscribe.SubscribeDto;
import com.cos.photogramstart.exception.CustomApiException;
import com.cos.photogramstart.repository.SubScribeRepository;
import com.cos.photogramstart.service.subscribe.SubScribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("subScribeService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubScribeServiceImpl implements SubScribeService {

    private final SubScribeRepository subScribeRepository;

    @Transactional
    @Override
    public void subscribe(Long fromUserId, Long toUserId ) {
        try {
            subScribeRepository.mSubscribe(fromUserId, toUserId);
        }catch (Exception e){
            throw new CustomApiException("이미 구독을 하셨습니다.");
        }
    }

    @Transactional
    @Override
    public void unSubscribe(Long fromUserId, Long toUserId) {
        subScribeRepository.mUnSubscribe(fromUserId, toUserId);
    }


    @Override
    public List<SubscribeDto> subscribeList(Long principalId, Long pageUserId) {
        return null;
    }
}
