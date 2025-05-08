package com.yscp.catchtable.domain.reserve.entity;

import com.yscp.catchtable.exception.CatchTableException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ReserveDataTest {

    @DisplayName("userReserve 메소드는")
    @Nested
    class Describe_with_userReserve {

        @DisplayName("유저가 예약을 했을 경우")
        @Nested
        class Context_with_valid_user_reserve {

            @DisplayName("예약 카운트를 증가한다.")
            @Test
            public void plus_reserve_count() {
                ReserveData reserveData = ReserveData.builder()
                        .idx(1L)
                        .canReserveCount(5)
                        .reservedCount(1)
                        .build();

                reserveData.userReserve(LocalDateTime.now(), 1L);

                Assertions.assertThat(reserveData.getReservedCount()).isEqualTo(2);
            }
        }

        @DisplayName("예약 횟수가 가득찼을 경우")
        @Nested
        class Context_with_max_reserve_count {

            @DisplayName("에러를 던진다.")
            @Test
            public void plus_reserve_count() {
                ReserveData reserveData = ReserveData.builder()
                        .idx(1L)
                        .canReserveCount(5)
                        .reservedCount(5)
                        .build();

                Assertions.assertThatThrownBy(() -> reserveData.userReserve(LocalDateTime.now(), 1L))
                        .isInstanceOf(CatchTableException.class);

            }
        }
    }


}
