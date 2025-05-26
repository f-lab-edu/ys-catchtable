package com.yscp.catchtable.domain.reserve.repository;

import com.yscp.catchtable.domain.reserve.entity.StoreReserve;
import com.yscp.catchtable.domain.reserve.entity.UserReserve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReserveRepository extends JpaRepository<UserReserve, Long> {
    List<UserReserve> findByUser_Idx(Long userIdx);

    List<UserReserve> findByStoreReserve(StoreReserve storeReserve);
}
