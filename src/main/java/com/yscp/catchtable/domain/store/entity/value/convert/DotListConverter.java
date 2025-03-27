package com.yscp.catchtable.domain.store.entity.value.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

@Convert
public class DotListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if (CollectionUtils.isEmpty(strings)) {
            return "";
        }

        return String.join(",", strings);

    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        String[] split = s.split(",");
        return Arrays.stream(split).toList();
    }
}
