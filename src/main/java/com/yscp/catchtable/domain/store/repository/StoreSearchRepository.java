package com.yscp.catchtable.domain.store.repository;

import com.yscp.catchtable.application.store.dto.StoreSearchDto;
import com.yscp.catchtable.domain.store.entity.Store;

import java.util.List;

public interface StoreSearchRepository {
    List<Store> findBySearchDto(StoreSearchDto searchDto);

}
