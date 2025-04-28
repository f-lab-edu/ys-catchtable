package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.domain.store.entity.Stores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreListDto {
    private List<StoreDto> storeList;

    public static StoreListDto of(Stores stores, Map<Long, List<StoreReserveDto>> reserveDtoMap, Map<Long, StoreBusinessDto> businessHourMap) {
        List<StoreDto> storeDtoList = stores.getStoreList()
                .stream()
                .map(store -> StoreDto.of(store,
                        reserveDtoMap.getOrDefault(store.getIdx(), new ArrayList<>()),
                        businessHourMap.getOrDefault(store.getIdx(), null)
                ))
                .toList();

        return new StoreListDto(storeDtoList);
    }

    public StoreListDto(List<StoreDto> storeList) {
        this.storeList = storeList;
    }

    public List<StoreDto> getList() {
        return storeList;
    }
}
