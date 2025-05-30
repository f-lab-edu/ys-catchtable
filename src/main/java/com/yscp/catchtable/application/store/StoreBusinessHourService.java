package com.yscp.catchtable.application.store;

import com.yscp.catchtable.application.store.dto.StoreBusinessDto;
import com.yscp.catchtable.domain.store.entity.value.DayType;
import com.yscp.catchtable.domain.store.repository.StoreBusinessHourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class StoreBusinessHourService {
    private final StoreBusinessHourRepository storeBusinessHourRepository;

    public Map<Long, StoreBusinessDto> findBusinessMap(List<Long> idxes, LocalDate localDate) {
        DayType day = DayType.from(localDate);
        return storeBusinessHourRepository.findByStoreIdxIn(idxes, day)
                .stream()
                .map(StoreBusinessDto::from)
                .collect(Collectors.toMap(StoreBusinessDto::getStoreIdx, Function.identity()));
    }

    public List<StoreBusinessDto> findByStoreIdx(Long storeIdx) {
        return storeBusinessHourRepository.findByStoreIdx(storeIdx);
    }
}
