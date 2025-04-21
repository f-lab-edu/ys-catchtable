package com.yscp.catchtable.application.store;

import com.yscp.catchtable.application.reserve.ReserveService;
import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.application.store.dto.StoreBusinessDto;
import com.yscp.catchtable.application.store.dto.StoreListDto;
import com.yscp.catchtable.domain.store.entity.Stores;
import com.yscp.catchtable.presentation.store.dto.request.StoreSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoreListService {
    private final StoreReadService storeReadService;
    private final StoreBusinessHourService storeBusinessHourService;
    private final ReserveService reserveService;

    public StoreListDto getStoreListDto(StoreSearchRequestDto storeSearchRequestDto) {
        Stores stores = Stores.from(storeReadService.findBySearchDto(storeSearchRequestDto.toSearchDto()));

        List<Long> idxes = stores.idxes();
        Map<Long, List<StoreReserveDto>> reserveDtoMap = reserveService.reserveDtoMapByStoreList(idxes, LocalDate.now().plusDays(14));

        Map<Long, StoreBusinessDto> businessHourMap = storeBusinessHourService.findBusinessMap(idxes);
        return StoreListDto.of(stores, reserveDtoMap, businessHourMap);
    }
}
