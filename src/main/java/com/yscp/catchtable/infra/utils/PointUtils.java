package com.yscp.catchtable.infra.utils;

import com.yscp.catchtable.exception.CatchTableException;
import com.yscp.catchtable.exception.ServerError;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;

public class PointUtils {

    public static Point convertPoint(Double longitude, Double latitude) {
        try {
            String pointWKT = String.format("POINT(%s %s)", longitude, latitude);
            return (Point) new WKTReader().read(pointWKT);

        } catch (Exception e) {
            throw new CatchTableException(ServerError.SERVER_ERROR);
        }
    }
}
