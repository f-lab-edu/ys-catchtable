package com.yscp.catchtable.application.reserve;

import com.yscp.catchtable.application.reserve.dto.ReserveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@RequiredArgsConstructor
@Service
public class ReserveService {

    public Map<Long, List<ReserveDto>> reserveDtoMapByStoreList(List<Long> idxes) {
        return null;
    }
}
