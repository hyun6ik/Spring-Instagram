package com.cos.photogramstart.domain.user;

import com.cos.photogramstart.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

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
}
