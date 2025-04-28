package com.yscp.catchtable.domain.reserve.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ReserveRepositoryTest {

    @Autowired
    private ReserveRepository reserveRepository;

    @DisplayName("resultDtoList")
    @Test
    void storeReserveDtoBeforeMaxDate() {
        Assertions.assertThatCode(() -> reserveRepository.storeReserveDtoBeforeMaxDate(List.of(1L, 2L), LocalDate.of(2025, 6, 20)))
                .doesNotThrowAnyException();
    }
}
