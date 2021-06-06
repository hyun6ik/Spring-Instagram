package com.cos.photogramstart.dto.response.subscribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscribeDto {

    private Long id;
    private String username;
    private String profileImageUrl;
    private Integer subscribeState;
    private Integer equalUserState;
}
