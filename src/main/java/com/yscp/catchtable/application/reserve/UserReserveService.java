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

    public void reserve(StoreReserveRegisterDto storeReserveRegisterDto) {

        StoreQueueDto storeQueueDto = new StoreQueueDto(storeReserveRegisterDto.storeReserveIdx().toString(), storeReserveRegisterDto.userIdx().toString());

        if (!isValidWaitingUser(storeQueueDto)) {
            throw new CatchTableException(BadRequestError.EXPIRED_TICKET);
        }

        Optional<ReserveData> reserveDataOptional = reserveService.findWithStoreByIdx(storeReserveRegisterDto.storeReserveIdx());

        reserveDataOptional.ifPresentOrElse(
                reserveData -> {
                    saveUserReserveData(
                            storeReserveRegisterDto,
                            reserveData,
                            storeQueueDto);
                },
                () -> {
                    throw new CatchTableException(BadRequestError.NULL_EXCEPTION);
                }
        );
    }

    private void saveUserReserveData(StoreReserveRegisterDto dto,
                                     ReserveData reserveData,
                                     StoreQueueDto storeQueueDto) {

        reserveData.userReserve(dto.requestDatetime(), dto.userIdx());

        UserReserveData userReserveData = UserReserveDataMapper.toEntity(reserveData, dto);

        if (userReserveData != null) {
            userReserveDataRepository.save(userReserveData);
        }

        storeQueueService.delete(storeQueueDto);
    }

    private boolean isValidWaitingUser(StoreQueueDto queueDto) {
        return storeQueueService.isValidWaitingUser(queueDto);
    }
}
