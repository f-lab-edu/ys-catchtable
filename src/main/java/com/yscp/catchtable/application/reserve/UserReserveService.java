package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.queue.StoreQueueService;
import com.yscp.catchtable.application.queue.dto.StoreQueueDto;
import com.yscp.catchtable.application.reserve.dto.StoreReserveRegisterDto;
import com.yscp.catchtable.application.reserve.mapper.UserReserveDataMapper;
import com.yscp.catchtable.domain.reserve.entity.ReserveData;
import com.yscp.catchtable.domain.reserve.entity.UserReserveData;
import com.yscp.catchtable.domain.reserve.repository.UserReserveDataRepository;
import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class UserReserveService {
    private final StoreQueueService storeQueueService;
    private final ReserveService reserveService;
    private final UserReserveDataRepository userReserveDataRepository;

    public void reserve(StoreReserveRegisterDto dto) {
        StoreQueueDto storeQueueDto = new StoreQueueDto(dto.storeReserveIdx().toString(), dto.userIdx().toString());

        if (ticketValid(storeQueueDto)) {
            throw new CatchTableException(BadRequestError.EXPIRED_TICKET);
        }

        Optional<ReserveData> reserveDataOptional = reserveService.findWithStoreByIdx(dto.storeReserveIdx());

        reserveDataOptional.ifPresentOrElse(
                reserveData -> {
                    saveUserReserveData(dto, reserveData, storeQueueDto);
                },
                () -> {
                    throw new CatchTableException(BadRequestError.NULL_EXCEPTION);
                }
        );
    }

    private void saveUserReserveData(StoreReserveRegisterDto dto, ReserveData reserveData, StoreQueueDto storeQueueDto) {
        UserReserveData userReserveData = UserReserveDataMapper.toEntity(reserveData, dto);
        if (userReserveData != null) {
            userReserveDataRepository.save(userReserveData);
        }
        // 티켓 삭제
        storeQueueService.delete(storeQueueDto);
    }

    private boolean ticketValid(StoreQueueDto queueDto) {
        return storeQueueService.isValidTicket(queueDto);
    }
}
