package com.yscp.catchtable.application.store;

import com.yscp.catchtable.application.amenity.StoreAmenityReadService;
import com.yscp.catchtable.application.amenity.dto.StoreAmenityDto;
import com.yscp.catchtable.application.location.dto.LocationDto;
import com.yscp.catchtable.application.menu.MenuReadService;
import com.yscp.catchtable.application.menu.dto.MenuDto;
import com.yscp.catchtable.application.reserve.ReserveService;
import com.yscp.catchtable.application.reserve.dto.ReserveDto;
import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.application.store.dto.StoreBusinessDto;
import com.yscp.catchtable.application.store.dto.StoreDetailDto;
import com.yscp.catchtable.application.store.dto.StoreListDto;
import com.yscp.catchtable.domain.menu.entity.sort.MenuSort;
import com.yscp.catchtable.domain.store.entity.Store;
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
public class StoreReader {
    private final StoreReadService storeReadService;
    private final StoreBusinessHourService storeBusinessHourService;
    private final ReserveService reserveService;
    private final MenuReadService menuReadservice;
    private final StoreAmenityReadService amenityReadService;

    public StoreListDto getStoreListDto(StoreSearchRequestDto storeSearchRequestDto) {
        Stores stores = Stores.from(storeReadService.findBySearchDto(storeSearchRequestDto.toSearchDto()));

        List<Long> idxes = stores.idxes();
        Map<Long, List<StoreReserveDto>> reserveDtoMap = reserveService.reserveDtoMapByStoreList(idxes, LocalDate.now().plusDays(14));

        Map<Long, StoreBusinessDto> businessHourMap = storeBusinessHourService.findBusinessMap(idxes);
        return StoreListDto.of(stores, reserveDtoMap, businessHourMap);
    }

    public StoreDetailDto storeDetailDto(Long idx) {
        Store store = storeReadService.findByIdx(idx);
        List<ReserveDto> reserveDtoList = reserveService.reserveDtoList(store.getIdx(), LocalDate.now().plusDays(14));
        // 메뉴 조회
        List<MenuDto> menuList = menuReadservice.findMenuDtoByStoreIdxAndSort(store.getIdx(), MenuSort.ORD_DESC);
        // 편의시설 조회
        List<StoreAmenityDto> storeAmenities = amenityReadService.findAmenityDtoByStoreIdx(store.getIdx());
        // 영업시간 조회
        List<StoreBusinessDto> businessDto = storeBusinessHourService.findByStoreIdx(store.getIdx());
        // 위치정보 조회
        LocationDto locationDto = new LocationDto(store.getAddressCode(), store.getLocationName(), store.getPoint());

        return new StoreDetailDto(
                store.getIdx(),
                store.getCategory().getName(),
                store.getTel(),
                store.getIntroduce(),
                store.getFeeInformation(),
                locationDto,
                reserveDtoList,
                menuList,
                storeAmenities,
                businessDto
        );
    }
}
