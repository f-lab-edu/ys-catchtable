package com.yscp.catchtable.domain.store.repository;

import com.yscp.catchtable.application.store.dto.StoreBusinessDto;
import com.yscp.catchtable.domain.store.entity.StoreBusinessHour;
import com.yscp.catchtable.domain.store.entity.value.DayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreBusinessHourRepository extends JpaRepository<StoreBusinessHour, Long> {

    @Query(value = """
            SELECT sb
                            FROM StoreBusinessHour sb
                                            WHERE sb.store.idx in :storeIdxes
                                                        and (
                                                                    sb.day = :dayType
                                                                                or sb.day = com.yscp.catchtable.domain.store.entity.value.DayType.ALL)
            """)
    List<StoreBusinessHour> findByStoreIdxIn(@Param("storeIdxes") List<Long> storeIdxes,@Param("dayType") DayType dayType);


    @Query(value = """
            SELECT sb
                            FROM StoreBusinessHour sb
                                            WHERE sb.store.idx = :storeIdx
            """)
    List<StoreBusinessDto> findByStoreIdx(@Param("storeIdx") Long storeIdx);
}
