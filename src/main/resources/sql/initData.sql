INSERT INTO catchtable.store (idx, name, regular_holiday, category_idx, point, introduce, directions, parking_information, alcohol_information, fee_information, has_promotion, promotion_image, promotion_start_date, promotion_end_time, address_code, location_name, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (2, '스시소라 서초점', null, 1, null, '코우지 셰프가 운영하는 미들급 스시 오마카세', ' ', '매장 주차장(실내)
최대 2시간 주차 가능
주차 요금 무료

건물 뒷편에 주차장 입구가 있으며, 2시간 무료 주차가 가능하십니다.
카운터에서 확인 부탁드립니다.', '와인(화이트) 병당 2.5만원
위스키 병당 3만원
사케 병당 2.5만원
샴파에니 병당 2.5만원
소주 병당 3만원

화이트와인, 샴페인, 사케 (720ml 기준 25,000원)
소주,위스키(720ml 기준 30,000원)

*레드 와이은 반입불가이신점 양해 부탁드립니다.', '점심 6-8만원 | 저녁11만원', 0, null, null, null, '1165010800', '서초', '2025-04-01 12:59:47', 1, null, null);


INSERT INTO catchtable.store (idx, name, regular_holiday, category_idx, point, introduce, directions, parking_information, alcohol_information, fee_information, has_promotion, promotion_image, promotion_start_date, promotion_end_time, address_code, location_name, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (3, '청담윤 [스시 & 데판] 일식 오마카세', null, 1, null, '제니가 선택한 맛집', ' ', '발렛 요금 5,000원

발렛은 업장 주변에서 비상등 켜고 계시면 발렛기사분이 오셔서 도와주세요
(커피빈 앞이나 업장 정문)
*발렛비(주차비 포함) 2시간에 5000원', '와인(화이트) 1병까지무료


콜키지프리', '점심 6-8만원 | 저녁11만원', , 0, null, null, null, '1165010800', '청담', '2025-04-01 12:59:47', 1, null, null);



INSERT INTO catchtable.amenity (idx, code, name, image_url, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (1, 'CATCH_PAY', '예약금 0원 결제', null, null, 1, null, null);



INSERT INTO catchtable.menu (idx, store_idx, category_idx, price, name, description, image_url, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (1, 2, null, '120,000원', '고쿠(보리)', '720ML', null, 3, '2025-04-01 13:08:16', 1, null, null);
INSERT INTO catchtable.menu (idx, store_idx, category_idx, price, name, description, image_url, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (2, 2, null, '8,000원', '기린 이치방시보리(병)', '355ML', null, 4, '2025-04-01 13:08:16', 1, null, null);
INSERT INTO catchtable.menu (idx, store_idx, category_idx, price, name, description, image_url, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (3, 2, 1, '60,000원', '런치 카운터 오마카세', null, null, 1, '2025-04-01 13:11:50', 1, null, null);
INSERT INTO catchtable.menu (idx, store_idx, category_idx, price, name, description, image_url, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (4, 2, 2, '110,000원', '디너 카운터 오마카세', null, null, 2, '2025-04-01 13:11:50', 1, null, null);
INSERT INTO catchtable.menu (idx, store_idx, category_idx, price, name, description, image_url, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (5, 3, 3, '60,000원', '런치 카운터 오마카세', null, null, 1, '2025-04-01 13:11:50', 1, null, null);
INSERT INTO catchtable.menu (idx, store_idx, category_idx, price, name, description, image_url, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (6, 3, 4, '110,000원', '디너 카운터 오마카세', null, null, 2, '2025-04-01 13:11:50', 1, null, null);

--
INSERT INTO catchtable.menu_category (idx, store_idx, name, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (1, 2, '런치', 1, '2025-04-01 13:10:29', 1, null, null);
INSERT INTO catchtable.menu_category (idx, store_idx, name, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (2, 2, '디너', 1, '2025-04-01 13:10:29', 1, null, null);
INSERT INTO catchtable.menu_category (idx, store_idx, name, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (3, 3, '런치', 1, '2025-04-01 13:10:29', 1, null, null);
INSERT INTO catchtable.menu_category (idx, store_idx, name, ord, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (4, 3, '디너', 1, '2025-04-01 13:10:29', 1, null, null);

--
INSERT INTO catchtable.store_amenity (idx, store_idx, amenity_idx, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (1, 2, 1, '2025-04-01 22:29:35', 1, null, null);
INSERT INTO catchtable.store_amenity (idx, store_idx, amenity_idx, reg_datetime, reg_idx, mod_datetime, mod_idx) VALUES (2, 3, 1, '2025-04-01 22:29:35', 1, null, null);

--
INSERT INTO catchtable.store_business_hour (idx, day, store_idx, lunch_start_time, lunch_end_time, diner_start_time, diner_end_time, last_order) VALUES (1, 'ALL', 2, null, null, 1600, 2100, 2000);
INSERT INTO catchtable.store_business_hour (idx, day, store_idx, lunch_start_time, lunch_end_time, diner_start_time, diner_end_time, last_order) VALUES (1, 'ALL', 3, null, null, 1600, 2100, 2000);

--
INSERT INTO catchtable.store_category (idx, code, name, reg_datetime, mod_datetime) VALUES (null, 'SUSHI', '스시오마카세', '2025-04-01 13:04:36', null);

