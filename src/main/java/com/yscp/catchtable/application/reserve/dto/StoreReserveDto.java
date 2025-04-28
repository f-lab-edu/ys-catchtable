package com.yscp.catchtable.application.reserve.dto;

import java.time.LocalDate;

public interface StoreReserveDto {
    LocalDate getDate();

    Integer getReserve();

    Long getStoreIdx();
}
