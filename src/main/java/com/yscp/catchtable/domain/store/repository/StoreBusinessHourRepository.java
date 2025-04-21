package com.yscp.catchtable.domain.store.repository;

import com.yscp.catchtable.domain.store.entity.StoreBusinessHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreBusinessHourRepository extends JpaRepository<StoreBusinessHour, Long> {

    @Query(value = """
            SELECT sb
                            FROM StoreBusinessHour sb
                                            WHERE sb.store.idx in :storeIdxes
            """)
    List<StoreBusinessHour> findByStoreIdxIn(@Param("storeIdxes") List<Long> storeIdxes);
}
