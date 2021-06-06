package com.cos.photogramstart.domain.user;

import com.cos.photogramstart.domain.BaseTimeEntity;
import com.cos.photogramstart.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String website;
    private String bio;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl;
    private String role;


    //나는 연관관계의 주인이 아니다. 그로므로 테이블에 컬럼을 만들지마.
    //User를 Select할 때 해당 User id로 등록된 images들을 다 가져와
    //LAZY = User를 Select할 때 해당 User id로 등록된 image들을 가져오지마 -> 대신 getImages가 호출될 때 가져와
    //EAGEr = User를 Select할 때 해당 User id로 등록된 image들을 전부 Join해서 가져와
    @OneToMany(mappedBy = "user", cascade = ALL)
    @Builder.Default
    @JsonIgnoreProperties({"user"})
    private List<Image> images = new ArrayList<>();


    //연관관계 메소드
    public void addImage(Image image){
        this.getImages().add(image);
        image.setUser(this);
    }
}
