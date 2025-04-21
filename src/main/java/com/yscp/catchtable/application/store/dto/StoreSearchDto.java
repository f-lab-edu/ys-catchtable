package com.yscp.catchtable.application.store.dto;

import com.yscp.catchtable.domain.category.entitry.value.StoreCategoryCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;

@Getter
public class StoreSearchDto {
    private final String keyword;
    private final StoreCategoryCode type;
    private final PageRequest pageRequest;

    @Builder
    public StoreSearchDto(String keyword, String type, PageRequest pageRequest) {
        this.keyword = keyword;
        this.type = StoreCategoryCode.from(type);
        this.pageRequest = pageRequest;
    }

    public long getOffset() {
        return pageRequest.getOffset();
    }

    public long getLimit() {
        return pageRequest.getPageSize();
    }
}
