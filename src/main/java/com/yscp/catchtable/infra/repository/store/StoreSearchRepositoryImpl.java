package com.yscp.catchtable.infra.repository.store;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yscp.catchtable.application.store.dto.StoreSearchDto;
import com.yscp.catchtable.domain.category.entitry.value.StoreCategoryCode;
import com.yscp.catchtable.domain.store.entity.Store;
import com.yscp.catchtable.domain.store.repository.StoreSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.yscp.catchtable.domain.store.entity.QStore.store;

@RequiredArgsConstructor
@Repository
public class StoreSearchRepositoryImpl implements StoreSearchRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Store> findBySearchDto(StoreSearchDto searchDto) {
        return queryFactory.select(store)
                .from(store)
                .join(store.category)
                .where(
                        eqType(searchDto.getType())
                                .and(containTitle(searchDto.getKeyword()))
                )
                .orderBy(store.idx.desc())
                .offset(searchDto.getOffset())
                .limit(searchDto.getLimit())
                .fetch();
    }

    private BooleanBuilder containTitle(String keyword) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (keyword != null && !StringUtils.isEmpty(keyword)) {
            booleanBuilder.and(store.name.like("%" + keyword + "%"));
        }
        return null;
    }

    private BooleanBuilder eqType(StoreCategoryCode type) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (type != null) {
            booleanBuilder.and(store.category.code.eq(type));
        }
        return booleanBuilder;
    }
}
