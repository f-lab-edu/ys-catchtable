package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.domain.reserve.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ReserveService {
    private final ReserveRepository repository;

    public Map<Long, List<StoreReserveDto>> reserveDtoMapByStoreList(List<Long> idxes, LocalDate maxDate) {
        List<StoreReserveDto> storeReserveDtos = repository.storeReserveDtoBeforeMaxDate(idxes, maxDate);
        return storeReserveDtos.stream()
                .collect(Collectors.groupingBy(StoreReserveDto::getStoreIdx, Collectors.toList()));
    }
}
