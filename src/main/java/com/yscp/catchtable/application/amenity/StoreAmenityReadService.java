package com.yscp.catchtable.application.amenity;

import com.yscp.catchtable.application.amenity.dto.StoreAmenityDto;
import com.yscp.catchtable.domain.amenity.entity.StoreAmenity;
import com.yscp.catchtable.domain.amenity.repository.StoreAmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class StoreAmenityReadService {
    private final StoreAmenityRepository storeAmenityRepository;

    public List<StoreAmenity> findByStoreIdx(Long idx) {
        Objects.requireNonNull(idx, "Store idx must not be null");
        return storeAmenityRepository.findByStoreIdx(idx);
    }

    public List<StoreAmenityDto> findAmenityDtoByStoreIdx(Long idx) {
        return findByStoreIdx(idx)
                .stream()
                .map(StoreAmenityDto::from)
                .toList();
    }
}
