package com.cos.photogramstart.repository;

import com.cos.photogramstart.domain.subscribe.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubScribeRepository extends JpaRepository<Subscribe,Long> {

    @Modifying
    @Query(value = "insert INTO photogram.subscribe(fromUser_id, toUser_id,createdDate) VALUES(:fromUserId, :toUserId,now())", nativeQuery = true)
    void mSubscribe(Long fromUserId, Long toUserId); //1(변경된 행의 개수가 리턴됨), -1

    @Modifying
    @Query(value = "DELETE FROM photogram.subscribe where fromUser_id =:fromUserId AND toUser_id =:toUserId", nativeQuery = true)
    void mUnSubscribe(Long fromUserId, Long toUserId);

    @Query(value = "SELECT count(*) FROM photogram.subscribe WHERE fromUser_id = :principalId AND toUser_id = :pageUserId ", nativeQuery = true)
    int mSubscribeState(Long principalId, Long pageUserId);

    @Query(value = "SELECT count(*) FROM photogram.subscribe WHERE fromUser_id = :pageUserId", nativeQuery = true)
    int mSubscribeCount(Long pageUserId);
}
