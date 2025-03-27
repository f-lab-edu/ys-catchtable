package com.yscp.catchtable.domain.store.entity.value;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

    @Column(nullable = false)
    private String displayAddress;
    @Column(nullable = false)
    private String detailAddress;

    @Builder
    public Address(String displayAddress, String detailAddress) {
        this.displayAddress = displayAddress;
        this.detailAddress = detailAddress;
    }
}
