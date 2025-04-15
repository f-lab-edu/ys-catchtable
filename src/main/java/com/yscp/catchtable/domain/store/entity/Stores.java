package com.yscp.catchtable.domain.store.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class Stores {

    private final List<Store> storeList;

    public Stores(List<Store> storeList) {
        this.storeList = storeList;
    }


    public static Stores from(List<Store> sotreList) {
        return new Stores(sotreList);
    }

    public List<Long> idxes() {
        return storeList.stream()
                .map(Store::getIdx)
                .toList();
    }
}
