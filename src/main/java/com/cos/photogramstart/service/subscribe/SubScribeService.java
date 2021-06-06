package com.cos.photogramstart.service.subscribe;

import com.cos.photogramstart.dto.response.subscribe.SubscribeDto;

import java.util.List;

public interface SubScribeService {

    void subscribe(Long toUserId, Long fromUserId);

    void unSubscribe(Long toUserId, Long fromUserId);

    List<SubscribeDto> subscribeList(Long id, Long pageUserId);
}
