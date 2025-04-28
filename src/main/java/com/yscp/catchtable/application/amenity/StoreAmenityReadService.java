package com.yscp.catchtable.application.amenity;

import com.yscp.catchtable.application.amenity.dto.StoreAmenityDto;
import com.yscp.catchtable.domain.amenity.entity.StoreAmenity;
import com.yscp.catchtable.domain.amenity.repository.StoreAmenityRepository;
import com.yscp.catchtable.exception.BadRequestError;
import com.yscp.catchtable.exception.CatchTableException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoreAmenityReadService {
    private final StoreAmenityRepository storeAmenityRepository;

    public List<StoreAmenity> findByStoreIdx(Long idx) {
        if (idx == null) {
            throw new CatchTableException(BadRequestError.NULL_EXCEPTION, "상품이 존재하지 않습니다.");
        }

        return storeAmenityRepository.findByStoreIdx(idx);
    }

    public List<StoreAmenityDto> findAmenityDtoByStoreIdx(Long idx) {
        return findByStoreIdx(idx)
                .stream()
                .map(StoreAmenityDto::from)
                .toList();
    }
}
