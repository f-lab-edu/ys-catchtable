package com.yscp.catchtable.infra.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;

class PointUtilsTest {


    @DisplayName("포인트 생성 테스트")
    @Test
    void createPoint() {
        double x = 37.5189323;
        double y = 126.88222735;
        Point point = PointUtils.convertPoint(x, y);
        Assertions.assertThat(point.getX()).isEqualTo(x);
        Assertions.assertThat(point.getY()).isEqualTo(y);
    }
}
