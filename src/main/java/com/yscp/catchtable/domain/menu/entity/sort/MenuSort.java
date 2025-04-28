package com.yscp.catchtable.domain.menu.entity.sort;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
@Getter
public enum MenuSort {
    ORD_DESC(Sort.by(Sort.Direction.DESC, "idx")),
    ;
    private final Sort sort;
}
