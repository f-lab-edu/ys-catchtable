package com.yscp.catchtable.application.review.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@RequiredArgsConstructor
@Service
public class ReviewService {
    public Map<Long, StoreReviewDto> reviewDtoMapByStoreList(List<Long> idxes) {
        return null;
    }
}
