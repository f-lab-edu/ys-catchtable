package com.yscp.catchtable.application.menu.dto;

import com.yscp.catchtable.domain.menu.entity.Menu;

public record MenuDto(
        Long idx,
        String name,
        String menuImageUrl
) {
    public static MenuDto from(Menu menu) {
        return new MenuDto(menu.getIdx(), menu.getName(), menu.getImageUrl());
    }
}
