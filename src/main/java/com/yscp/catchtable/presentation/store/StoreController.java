package com.yscp.catchtable.presentation.store;

import com.yscp.catchtable.application.store.StoreListService;
import com.yscp.catchtable.application.store.dto.StoreListDto;
import com.yscp.catchtable.presentation.store.dto.request.StoreSearchRequestDto;
import com.yscp.catchtable.presentation.store.dto.response.StoreListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class StoreController {

    private final StoreListService storeListService;

    @GetMapping("/stores")
    public ResponseEntity<StoreListResponseDto> getStores(StoreSearchRequestDto request) {
        StoreListDto storeListDto = storeListService.getStoreListDto(request);

        return ResponseEntity.ok(StoreListResponseDto.from(storeListDto));
    }
}
