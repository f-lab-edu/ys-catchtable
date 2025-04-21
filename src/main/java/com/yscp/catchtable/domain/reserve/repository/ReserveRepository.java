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
                    select 
                                   reserve_data AS date,
                                   IF(SUM(reserved_count) > 0, true, false) AS reserve,
                                   store_idx
                    from store_reserve_data
                    where store_idx in :storeIdxes
                    AND reserve_data <= :date
                    group by  store_idx,date
                    """
            , nativeQuery = true)
    List<StoreReserveDto> storeReserveDtoBeforeMaxDate(@Param("storeIdxes") List<Long> storeIdxes, @Param("date") LocalDate date);
}
