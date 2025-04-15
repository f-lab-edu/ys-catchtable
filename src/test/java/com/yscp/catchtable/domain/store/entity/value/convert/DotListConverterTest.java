package com.yscp.catchtable.domain.store.entity.value.convert;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DotListConverterTest {


    @DisplayName("listToString ")
    @Test
    void ListToString() {
        DotListConverter dotListConverter = new DotListConverter();
        List<String> strings = List.of("1", "2", "3", "4");
        String result = dotListConverter.convertToDatabaseColumn(strings);

        assertThat(result).isEqualTo("1,2,3,4");
    }

    @DisplayName("stringToList")
    @Test
    void stringToList() {
        DotListConverter dotListConverter = new DotListConverter();
        String strings = "1,2,3,4";
        List<String> result = dotListConverter.convertToEntityAttribute(strings);

        Assertions.assertThat(result).containsExactly("1", "2", "3", "4");
    }

}
