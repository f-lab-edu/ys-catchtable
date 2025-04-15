package com.yscp.catchtable.domain.store.repository;

import com.yscp.catchtable.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
