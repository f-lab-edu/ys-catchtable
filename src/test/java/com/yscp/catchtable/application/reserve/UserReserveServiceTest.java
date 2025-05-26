package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.queue.StoreQueueService;
import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.application.reserve.dto.StoreReserveRegisterDto;
import com.yscp.catchtable.domain.reserve.entity.StoreReserve;
import com.yscp.catchtable.domain.reserve.entity.UserReserve;
import com.yscp.catchtable.domain.reserve.repository.UserReserveRepository;
import com.yscp.catchtable.exception.CatchTableException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@DisplayName("UserReserveService ")
@ExtendWith(MockitoExtension.class)
class UserReserveServiceTest {
    @Mock
    private StoreQueueService storeQueueService;
    @Mock
    private ReserveService reserveService;
    @Mock
    private UserReserveRepository userReserveDataRepository;
    @InjectMocks
    private UserReserveService userReserveService;

    private StoreReserveRegisterDto storeReserveRegisterDto;

    @DisplayName("reserve 메소드는")
    @Nested
    class Describe_with_reserve {

        @BeforeEach
        void setUp() {
            storeReserveRegisterDto = new StoreReserveRegisterDto(
                    1L,
                    1L,
                    "CARD",
                    "234123",
                    "DATE",
                    4,
                    LocalDateTime.now()
            );
        }

        @DisplayName("대기열에 존재하는 유저가 요청 했을 경우 ")
        @Nested
        class Context_with_valid_waitingUser {

            @DisplayName("예약 정보를 저장한다.")
            @Test
            public void save_user_reserve_data() {
                StoreReserve mockReserveData = StoreReserve.builder()
                        .idx(1L)
                        .reserveTime("1320")
                        .reservedCount(10)
                        .canReserveCount(20)
                        .build();

                Mockito.when(reserveService.findWithStoreByIdx(any())).thenReturn(Optional.of(mockReserveData));

                Mockito.when(storeQueueService.isValidWaitingUser(Mockito.any(StoreQueueDto.class))).thenReturn(Boolean.TRUE);

                userReserveService.reserve(storeReserveRegisterDto);

                Mockito.verify(userReserveDataRepository, Mockito.times(1)).save(any(UserReserve.class));
                Mockito.verify(storeQueueService, Mockito.times(1)).delete(any(StoreQueueDto.class));
            }
        }


        @DisplayName("대기열에 존재하지 않는 유저가 예약 요청을 했을 경우")
        @Nested
        class Context_with_invalid_waitingUser {

            @DisplayName("에러를 던진다.")
            @Test
            public void save_user_reserve_data() {
                Mockito.when(storeQueueService.isValidWaitingUser(Mockito.any(StoreQueueDto.class))).thenReturn(Boolean.TRUE);

                Mockito.when(reserveService.findWithStoreByIdx(any())).thenReturn(Optional.empty());

                Assertions.assertThatThrownBy(() -> userReserveService.reserve(storeReserveRegisterDto))
                        .isInstanceOf(CatchTableException.class);
            }
        }


        @DisplayName("상점 예약 정보가 존재하지 않을 경우")
        @Nested
        class Context_with_not_found_store_reserve_data {

            @DisplayName("에러를 던진다.")
            @Test
            public void save_user_reserve_data() {
                Mockito.when(storeQueueService.isValidWaitingUser(Mockito.any(StoreQueueDto.class))).thenReturn(Boolean.FALSE);

                Assertions.assertThatThrownBy(() -> userReserveService.reserve(storeReserveRegisterDto))
                        .isInstanceOf(CatchTableException.class);
            }
        }
    }


}
