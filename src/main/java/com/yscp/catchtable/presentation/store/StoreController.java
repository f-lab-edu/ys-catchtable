package com.yscp.catchtable.presentation.store;

import com.yscp.catchtable.application.store.StoreReader;
import com.yscp.catchtable.application.store.dto.StoreDetailDto;
import com.yscp.catchtable.application.store.dto.StoreDtos;
import com.yscp.catchtable.presentation.store.dto.request.StoreSearchRequestDto;
import com.yscp.catchtable.presentation.store.dto.response.StoreDetailResponseDto;
import com.yscp.catchtable.presentation.store.dto.response.StoresResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RequiredArgsConstructor
@RestController
public class StoreController {

    private final StoreReader storeListService;

    @GetMapping("/stores")
    public ResponseEntity<StoresResponseDto> getStores(StoreSearchRequestDto request) {
        StoreDtos storeListDto = storeListService.getStoreListDto(request, LocalDate.now());

        return ResponseEntity.ok(StoresResponseDto.from(storeListDto));
    }

    @GetMapping("/stores/{idx}")
    public ResponseEntity<StoreDetailResponseDto> storeDetail(@PathVariable Long idx) {
        StoreDetailDto storeDetailDto = storeListService.getStoreDetailDto(idx, LocalDate.now());
        StoreDetailResponseDto storeDetailResponseDto = StoreDetailResponseDto.from(storeDetailDto);
        return ResponseEntity.ok(storeDetailResponseDto);
    }
}
