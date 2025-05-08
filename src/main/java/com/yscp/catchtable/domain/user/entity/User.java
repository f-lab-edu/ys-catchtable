package com.yscp.catchtable.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String email;

    private String password;

    private String phone;

    private String nickname;

    private LocalDateTime regDatetime;

    private LocalDateTime modDatetime;

    @Builder
    public User(Long idx, String email, String password, String phone, String nickname, LocalDateTime regDatetime, LocalDateTime modDatetime) {
        this.idx = idx;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.nickname = nickname;
        this.regDatetime = regDatetime;
        this.modDatetime = modDatetime;
    }
}
