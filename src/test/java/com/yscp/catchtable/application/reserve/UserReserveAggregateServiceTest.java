package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.queue.StoreQueueService;
import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.domain.category.entitry.StoreCategory;
import com.yscp.catchtable.domain.category.entitry.value.StoreCategoryCode;
import com.yscp.catchtable.domain.reserve.entity.StoreReserve;
import com.yscp.catchtable.domain.reserve.entity.UserReserve;
import com.yscp.catchtable.domain.reserve.entity.value.StoreReserveStatus;
import com.yscp.catchtable.domain.reserve.repository.StoreReserveRepository;
import com.yscp.catchtable.domain.reserve.repository.UserReserveRepository;
import com.yscp.catchtable.domain.store.entity.Store;
import com.yscp.catchtable.domain.store.repository.StoreRepository;
import com.yscp.catchtable.infra.utils.PointUtils;
import com.yscp.catchtable.presentation.reserve.dto.StoreReserveRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class UserReserveAggregateServiceTest {

    @Autowired
    private UserReserveAggregateService userReserveAggregateService;

    @Autowired
    private StoreQueueService storeQueueService;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreReserveRepository storeReserveRepository;

    @Autowired
    private UserReserveRepository userReserveRepository;

    Store store;

    StoreReserve storeReserve;

    @BeforeEach
    void setUp() {
        // 상점 등록
        store = Store.builder()
                .name("Test 상점")
                .holiday(List.of("MON"))
                .addressCode("강남1단지")
                .category(StoreCategory.builder()
                        .idx(1L)
                        .code(StoreCategoryCode.SUSHI)
                        .build())
                .point(PointUtils.convertPoint(37.5189323, 126.88222735))
                .introduce("테스트 상점입니다.")
                .directions("길안내")
                .build();

        storeRepository.save(store);

        storeReserve = StoreReserve.builder()
                .reserveDate(LocalDate.now().plusDays(1))
                .reserveTime("1230")
                .maxUserCount(10)
                .minUserCount(2)
                .canReserveCount(10)
                .reservedCount(0)
                .reserveStatus(StoreReserveStatus.ACTIVE)
                .store(store)
                .regDatetime(LocalDateTime.now())
                .build();

        storeReserveRepository.save(storeReserve);
    }

    @AfterEach
    void afterEach() {
        storeRepository.delete(store);
        storeReserveRepository.delete(storeReserve);
    }

    @DisplayName("동시요청 테스트")
    @Test
    void name() throws InterruptedException {
        // 대기열에 등록
        StoreQueueDto storeQueueDto = new StoreQueueDto(storeReserve.getIdx().toString(), "1");
        storeQueueService.registerWaiting(storeQueueDto);

        StoreReserveRequestDto storeReserveRequestDto = new StoreReserveRequestDto(1L,
                storeReserve.getIdx(),
                "CATCH_PAY",
                "Test",
                "데이트",
                4
        );


        int threadCount = 10;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);


        for (int i = 0; i < threadCount; i++) {
            executor.execute(() -> {
                try {
                    userReserveAggregateService.reserve(storeReserveRequestDto);
                    System.out.println("예약 성공");
                } catch (Exception e) {
                    System.out.println("예약 실패: " + e.getMessage());
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        List<UserReserve> byUserIdx = userReserveRepository.findByStoreReserve(storeReserve);
        Assertions.assertThat(byUserIdx.size()).isEqualTo(1);
    }
}
