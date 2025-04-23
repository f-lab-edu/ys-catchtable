package com.yscp.catchtable.presentation.menu.dto.response;

import com.yscp.catchtable.application.menu.dto.MenuDto;

public record MenuResponseDto(
        Long idx,
        String name,
        String menuImage
) {
    public static MenuResponseDto from(MenuDto menuDto) {
        return new MenuResponseDto(menuDto.idx(),
                menuDto.name(),
                menuDto.menuImageUrl());
    }
}
