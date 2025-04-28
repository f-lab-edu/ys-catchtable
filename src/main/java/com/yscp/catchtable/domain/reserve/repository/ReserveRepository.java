package com.yscp.catchtable.domain.reserve.repository;

import com.yscp.catchtable.application.reserve.dto.StoreReserveDto;
import com.yscp.catchtable.domain.reserve.entity.ReserveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReserveRepository extends JpaRepository<ReserveData, Long> {

    @Query(
            value = """
                    SELECT 
                       reserve_data AS date,
                       SUM(reserved_count) AS reserve,
                       store_idx
                    FROM store_reserve_data
                    WHERE store_idx IN :storeIdxes
                    AND reserve_data <= :date
                    GROUP BY  store_idx,date
                    """
            , nativeQuery = true)
    List<StoreReserveDto> findStoreReserveDtoListBeforeMaxDate(@Param("storeIdxes") List<Long> storeIdxes, @Param("date") LocalDate date);

    @Query(
            value = """
                     SELECT 
                    reserve_data AS date,
                    SUM(reserved_count)  AS reserve,
                    store_idx
                     FROM store_reserve_data
                     WHERE store_idx = :idx
                     AND reserve_data <= :date
                     GROUP BY  store_idx,date
                    """
            , nativeQuery = true)
    List<StoreReserveDto> getStoreReserveDtoBeforeMaxDate(@Param("idx") Long idx, @Param("date") LocalDate date);
}
