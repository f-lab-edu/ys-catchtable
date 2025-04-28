package com.yscp.catchtable.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class ThirdPartyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "user_idx")
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    private String type;
    private String email;
    private String nickname;
    private String profileUrl;
    private LocalDateTime regDatetime;
    private LocalDateTime modDatetime;

    @Builder
    public ThirdPartyUser(Long idx, User user, String type, String email, String nickname, String profileUrl, LocalDateTime regDatetime, LocalDateTime modDatetime) {
        this.idx = idx;
        this.user = user;
        this.type = type;
        this.email = email;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.regDatetime = regDatetime;
        this.modDatetime = modDatetime;
    }
}
