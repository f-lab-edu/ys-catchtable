package com.yscp.catchtable.domain.amenity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String code;

    private String name;

    private LocalDateTime regDatetime;

    private Long regIdx;

    private LocalDateTime modDatetime;

    private Long modIdx;

    public Amenity(Long idx, String code, String name, LocalDateTime regDatetime, Long regIdx, LocalDateTime modDatetime, Long modIdx) {
        this.idx = idx;
        this.code = code;
        this.name = name;
        this.regDatetime = regDatetime;
        this.regIdx = regIdx;
        this.modDatetime = modDatetime;
        this.modIdx = modIdx;
    }
}
