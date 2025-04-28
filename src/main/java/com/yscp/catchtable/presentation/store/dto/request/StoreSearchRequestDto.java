package com.yscp.catchtable.presentation.store.dto.request;

import com.yscp.catchtable.application.store.dto.StoreSearchDto;
import org.springframework.data.domain.PageRequest;

public record StoreSearchRequestDto(
        String type,
        Integer page,
        Integer limit,
        String keyword
) {
    public StoreSearchDto toSearchDto() {
        int pageNo = page == null ? 1 : page;
        return StoreSearchDto.builder()
                .type(type)
                .keyword(keyword)
                .pageRequest(PageRequest.of(Math.max(pageNo - 1, 0), limit))
                .build();
    }
}
