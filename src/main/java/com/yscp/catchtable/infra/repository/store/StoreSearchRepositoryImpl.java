package com.yscp.catchtable.infra.repository.store;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yscp.catchtable.application.store.dto.StoreSearchDto;
import com.yscp.catchtable.domain.store.entity.Store;
import com.yscp.catchtable.domain.store.repository.StoreSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class StoreSearchRepositoryImpl implements StoreSearchRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Store> findBySearchDto(StoreSearchDto searchDto) {
        return List.of();
    }
}
