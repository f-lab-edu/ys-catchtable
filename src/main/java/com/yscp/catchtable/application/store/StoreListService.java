package com.yscp.catchtable.application.store;

import com.yscp.catchtable.application.reserve.ReserveService;
import com.yscp.catchtable.application.reserve.dto.ReserveDto;
import com.yscp.catchtable.application.review.dto.ReviewService;
import com.yscp.catchtable.application.review.dto.StoreReviewDto;
import com.yscp.catchtable.application.store.dto.StoreImageDto;
import com.yscp.catchtable.application.store.dto.StoreListDto;
import com.yscp.catchtable.domain.store.entity.Stores;
import com.yscp.catchtable.presentation.store.dto.request.StoreSearchRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoreListService {
    private final StoreReadService storeReadService;
    private final ReviewService reviewService;
    private final ReserveService reserveService;

    public StoreListDto getStoreListDto(StoreSearchRequestDto storeSearchRequestDto) {
        Stores stores = Stores.from(storeReadService.findBySearchDto(storeSearchRequestDto.toSearchDto()));

        List<Long> idxes = stores.idxes();
        Map<Long, StoreReviewDto> reviewDtoMap = reviewService.reviewDtoMapByStoreList(idxes);
        Map<Long, List<ReserveDto>> reserveDtoMap = reserveService.reserveDtoMapByStoreList(idxes);

        return StoreImageDto.of(stores, reserveDtoMap, reviewDtoMap);
    }
}
