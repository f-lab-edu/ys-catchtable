package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.reserve.dto.ReserveDto;
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

    public Map<Long, List<StoreReserveDto>> findReserveDtoMapByStores(List<Long> idxes, LocalDate maxDate) {
        List<StoreReserveDto> storeReserveDtos = repository.findStoreReserveDtoListBeforeMaxDate(idxes, maxDate);
        return storeReserveDtos.stream()
                .collect(Collectors.groupingBy(StoreReserveDto::getStoreIdx, Collectors.toList()));
    }

    public List<ReserveDto> findReserveDtos(Long idx, LocalDate localDate) {
        return repository.getStoreReserveDtoBeforeMaxDate(idx, localDate)
                .stream()
                .map(ReserveDto::from)
                .toList();
    }
}
