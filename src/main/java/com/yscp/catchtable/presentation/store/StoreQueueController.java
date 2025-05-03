package com.yscp.catchtable.presentation.store;

import com.yscp.catchtable.application.queue.StoreQueueService;
import com.yscp.catchtable.application.store.mapper.StoreQueueMapper;
import com.yscp.catchtable.presentation.store.dto.StoreQueueRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StoreQueueController {
    private final StoreQueueService storeQueueService;

    @PostMapping("/store/reservation/enter")
    public ResponseEntity<Void> enter(@RequestBody StoreQueueRequestDto storeQueueRequestDto) {
        storeQueueService.registerWaiting(StoreQueueMapper.toQueueDto(storeQueueRequestDto));
        return ResponseEntity.ok().build();
    }
}
