package com.yscp.catchtable.domain.store.repository;

import com.yscp.catchtable.application.store.dto.StoreSearchDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class StoreSearchRepositoryTest {

    @Autowired
    private StoreSearchRepository storeSearchRepository;

    @DisplayName("상점 조회")
    @Test
    void search() {
        StoreSearchDto storeSearchDto = new StoreSearchDto(null, null, PageRequest.of(0, 20));
        Assertions.assertThatCode(() -> storeSearchRepository.findBySearchDto(storeSearchDto))
                .doesNotThrowAnyException();
    }
}
