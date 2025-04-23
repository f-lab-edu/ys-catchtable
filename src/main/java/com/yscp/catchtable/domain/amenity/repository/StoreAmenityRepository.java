package com.yscp.catchtable.domain.amenity.repository;

import com.yscp.catchtable.domain.amenity.entity.StoreAmenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreAmenityRepository extends JpaRepository<StoreAmenity, Long> {
    List<StoreAmenity> findByStoreIdx(Long idx);
}
