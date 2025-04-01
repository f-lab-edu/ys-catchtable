package com.yscp.catchtable.domain.store.entity;

import com.yscp.catchtable.domain.store.entity.value.Address;
import com.yscp.catchtable.domain.store.entity.value.Promotion;
import com.yscp.catchtable.domain.store.entity.value.convert.DotListConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Embedded
    private Address address;

    @Convert(converter = DotListConverter.class)
    private List<String> holiday;

    @Column(nullable = false)
    private Point point;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private String directions;

    private String parkingInformation;

    private String alcoholInformation;

    private String feeInformation;

    private String salesInformation;

    @Embedded
    private Promotion promotion;

    private String addressCode;
    private LocalDateTime regDatetime;
    private Long regIdx;
    private LocalDateTime modDatetime;
    private Long modIdx;


}
