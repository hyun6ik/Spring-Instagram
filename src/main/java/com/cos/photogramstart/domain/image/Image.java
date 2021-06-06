package com.cos.photogramstart.domain.image;

import com.cos.photogramstart.domain.BaseTimeEntity;
import com.cos.photogramstart.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption; //나 오늘 너무 피곤해 ㅜㅜㅡ
    private String postImageUrl; //사진을 전송받아서 그 사진을 서버에 특정 폴더에 저장 - DB에 그 저장된 경로를 insert

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //이미지 좋아요

    //댓글
}
