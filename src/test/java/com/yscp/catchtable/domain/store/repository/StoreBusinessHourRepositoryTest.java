package com.yscp.catchtable.domain.store.repository;

import com.yscp.catchtable.domain.store.entity.value.DayType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class StoreBusinessHourRepositoryTest {

    @Autowired
    private StoreBusinessHourRepository storeBusinessHourRepository;

    @DisplayName("findByStoreIdxIn")
    @Test
    void findByStoreIdxIn() {
        Assertions.assertThatCode(() -> storeBusinessHourRepository.findByStoreIdxIn(List.of(1L, 2L, 3L), DayType.THU))
                .doesNotThrowAnyException();
    }
}
