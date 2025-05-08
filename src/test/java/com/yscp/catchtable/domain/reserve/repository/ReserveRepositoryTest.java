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

    @DisplayName("resultDtos")
    @Test
    void findStoreReserveDtoListBeforeMaxDate() {
        Assertions.assertThatCode(() -> reserveRepository.findStoreReserveDtoListBeforeMaxDate(List.of(1L, 2L), LocalDate.of(2025, 6, 20)))
                .doesNotThrowAnyException();
    }

    @DisplayName("storeReserveDtoBeforeMaxDate")
    @Test
    void getStoreReserveDtoBeforeMaxDate() {
        Assertions.assertThatCode(() -> reserveRepository.getStoreReserveDtoBeforeMaxDate(1L, LocalDate.of(2025, 6, 20)))
                .doesNotThrowAnyException();
    }

    @DisplayName("findByStore_IdxAndReserveDate")
    @Test
    void findByStore_IdxAndReserveDate() {
        Assertions.assertThatCode(() -> reserveRepository.findByStore_IdxAndReserveDate(1L, LocalDate.of(2025, 6, 20)))
                .doesNotThrowAnyException();
    }

    @DisplayName("findWithStoreByIdx")
    @Test
    void findWithStoreByIdx() {
        Assertions.assertThatCode(() -> reserveRepository.findWithStoreByIdx(5L))
                .doesNotThrowAnyException();
    }
}

