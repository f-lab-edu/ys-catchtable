package com.yscp.catchtable.application.store;

import com.yscp.catchtable.application.store.dto.StoreBusinessDto;
import com.yscp.catchtable.domain.store.repository.StoreBusinessHourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class StoreBusinessHourService {
    private final StoreBusinessHourRepository storeBusinessHourRepository;


    public Map<Long, StoreBusinessDto> findBusinessMap(List<Long> idxes) {
        return storeBusinessHourRepository.findByStoreIdxIn(idxes)
                .stream()
                .map(StoreBusinessDto::from)
                .collect(Collectors.toMap(StoreBusinessDto::getStoreIdx, Function.identity()));
    }
}
