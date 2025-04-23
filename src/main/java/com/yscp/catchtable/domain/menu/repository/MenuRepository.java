package com.yscp.catchtable.domain.menu.repository;

import com.yscp.catchtable.domain.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByStoreIdx(Long idx, Sort sort);
}
