package com.yscp.catchtable.domain.reserve.repository;

import com.yscp.catchtable.domain.reserve.entity.UserReserveData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReserveDataRepository extends JpaRepository<UserReserveData, Long> {
}
