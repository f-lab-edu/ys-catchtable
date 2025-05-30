package com.yscp.catchtable.application.store;

import com.yscp.catchtable.application.store.dto.StoreSearchDto;
import com.yscp.catchtable.domain.store.entity.Store;
import com.yscp.catchtable.domain.store.repository.StoreRepository;
import com.yscp.catchtable.domain.store.repository.StoreSearchRepository;
import com.yscp.catchtable.exception.CatchTableException;
import com.yscp.catchtable.exception.NotFoundError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoreReadService {
    private final StoreSearchRepository storeSearchRepository;
    private final StoreRepository storeRepository;

    public List<Store> findBySearchDto(StoreSearchDto searchDto) {
        return storeSearchRepository.findBySearchDto(searchDto);
    }

    public Store findByIdx(Long idx) {
        return storeRepository.findById(idx)
                .orElseThrow(() -> new CatchTableException(NotFoundError.NOT_FOUND_STORE));
    }
}
