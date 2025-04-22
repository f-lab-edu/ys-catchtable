package com.yscp.catchtable.domain.amenity.entity;

import com.yscp.catchtable.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class StoreAmenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @JoinColumn(name = "store_idx")
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amenity_idx")
    private Amenity amenity;
    private String memo;

    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;
}
