package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.domain.store.entity.Stores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreDtos {
    private List<StoreDto> stores;

    public static StoreDtos of(Stores stores, Map<Long, List<StoreReserveDto>> reserveDtoMap, Map<Long, StoreBusinessDto> businessHourMap) {
        List<StoreDto> stroeDtos = stores.getStoreList()
                .stream()
                .map(store -> StoreDto.of(store,
                        reserveDtoMap.getOrDefault(store.getIdx(), new ArrayList<>()),
                        businessHourMap.getOrDefault(store.getIdx(), null)
                ))
                .toList();

        return new StoreDtos(stroeDtos);
    }

    public StoreDtos(List<StoreDto> stores) {
        this.stores = stores;
    }

    public List<StoreDto> getList() {
        return stores;
    }
}
