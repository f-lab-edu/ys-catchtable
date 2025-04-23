package com.yscp.catchtable.domain.store.entity.value;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum DayType {
    ALL(0),
    MON(1),
    TUE(2),
    WED(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);

    private final int dayValue;
    private static final Map<Integer, DayType> MAPPING;

    static {
        MAPPING = Arrays.stream(values())
                .collect(Collectors.toMap(e -> e.dayValue, e -> e));
    }

    public static DayType from(LocalDate now) {
        return MAPPING.getOrDefault(now.getDayOfWeek()
                .getValue(), DayType.ALL);
    }
}
