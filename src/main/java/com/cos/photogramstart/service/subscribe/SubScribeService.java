package com.cos.photogramstart.service.subscribe;

public interface SubScribeService {

    void subscribe(Long toUserId, Long fromUserId);

    void unSubscribe(Long toUserId, Long fromUserId);
}
