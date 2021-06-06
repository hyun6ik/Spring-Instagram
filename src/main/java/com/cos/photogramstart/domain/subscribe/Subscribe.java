package com.cos.photogramstart.domain.subscribe;

import com.cos.photogramstart.domain.BaseTimeEntity;
import com.cos.photogramstart.domain.user.User;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name="subscribe_uk",
                        columnNames = {"fromUser_id", "toUser_id"}
                )
        }
)
public class Subscribe extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "fromUser_id")
    private User fromUser;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "toUser_id")
    private User toUser;


}
