package com.yscp.catchtable.application.menu;

import com.yscp.catchtable.application.menu.dto.MenuDto;
import com.yscp.catchtable.domain.menu.entity.Menu;
import com.yscp.catchtable.domain.menu.entity.sort.MenuSort;
import com.yscp.catchtable.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MenuReadService {
    private final MenuRepository menuRepository;

    public List<Menu> findByStoreIdxAndSort(Long idx, MenuSort menuSort) {
        Objects.requireNonNull(idx, "Store idx must not be null");
        return menuRepository.findByStoreIdx(idx, menuSort.getSort());
    }

    public List<MenuDto> findMenuDtoByStoreIdxAndSort(Long idx, MenuSort menuSort) {

        return findByStoreIdxAndSort(idx, menuSort)
                .stream()
                .map(MenuDto::from)
                .toList();

    }
}
