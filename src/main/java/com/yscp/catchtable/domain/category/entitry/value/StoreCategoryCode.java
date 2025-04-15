package com.yscp.catchtable.domain.category.entitry.value;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum StoreCategoryCode {
    SUSHI,
    ;

    private static final Map<String, StoreCategoryCode> MAPPING;

    static {
        MAPPING = Arrays.stream(StoreCategoryCode.values())
                .collect(Collectors.toMap(Enum::name, Function.identity()));
    }

    public static StoreCategoryCode from(String type) {
        return MAPPING.getOrDefault(type, null);
    }
}
