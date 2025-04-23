package com.yscp.catchtable.application.amenity;

import com.yscp.catchtable.domain.amenity.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AmenityReadService {
    private final AmenityRepository amenityRepository;
}
