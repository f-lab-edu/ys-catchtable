
-- amenity
CREATE TABLE `amenity` (
                           `idx` int NOT NULL AUTO_INCREMENT COMMENT '편의시설 식별자 번호',
                           `code` varchar(50) NOT NULL,
                           `name` varchar(50) NOT NULL COMMENT '코드명',
                           `reg_datetime` datetime DEFAULT NULL COMMENT '등록일시',
                           `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호',
                           `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                           `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호',
                           PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='편의시설';


--
CREATE TABLE `kakao_user` (
                              `idx` int NOT NULL AUTO_INCREMENT COMMENT '카카오 유저정보 식별자 번호',
                              `user_idx` int DEFAULT NULL COMMENT '유저 식별자번호',
                              `email` int NOT NULL COMMENT '카카오이메일',
                              `nickname` int NOT NULL COMMENT '닉네임 정보',
                              `profile_url` varchar(255) NOT NULL COMMENT '프로필 이미지 url',
                              `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                              `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                              PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='카카오 유저정보';



--
CREATE TABLE `menu` (
                        `idx` int NOT NULL AUTO_INCREMENT COMMENT '메뉴 식별자 번호 ',
                        `category_idx` int NOT NULL COMMENT '메뉴 카테고리 식별자번호',
                        `price` int NOT NULL COMMENT '가격',
                        `name` varchar(50) NOT NULL COMMENT '메뉴명 ',
                        `image_url` varchar(50) DEFAULT NULL,
                        `ord` int NOT NULL COMMENT '순서',
                        `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                        `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호 ',
                        `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                        `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호',
                        PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상점 메뉴 '


--

CREATE TABLE `menu_category` (
                                 `idx` int NOT NULL AUTO_INCREMENT COMMENT '메뉴 카테고리 식별자 번호',
                                 `name` varchar(50) NOT NULL COMMENT '카테고리명',
                                 `ord` int DEFAULT NULL COMMENT '순서',
                                 `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                                 `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호',
                                 `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                                 `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호',
                                 PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='메뉴 카테고리 '


--

CREATE TABLE `store` (
                         `idx` int NOT NULL AUTO_INCREMENT COMMENT '상점 식별자 번호',
                         `display_address` varchar(100) NOT NULL COMMENT '주소 표기명',
                         `detail_address` varchar(100) NOT NULL COMMENT '상세주소',
                         `regular_holiday` varchar(50) DEFAULT NULL COMMENT '정기 휴무 ',
                         `point` point NOT NULL COMMENT '좌표',
                         `introduce` text NOT NULL COMMENT '매장소개',
                         `directions` text NOT NULL COMMENT '찾아오는 방법(길안내)',
                         `parking_information` text COMMENT '주차안내',
                         `alcohol_information` text COMMENT '주류 안내(콜키지)',
                         `fee_information` varchar(50) DEFAULT NULL COMMENT '요금안내 ',
                         `sales_information` varchar(50) DEFAULT NULL COMMENT '영업안내',
                         `has_promotion` tinyint(1) NOT NULL DEFAULT '0',
                         `promotion_image` varchar(255) DEFAULT NULL,
                         `promotion_start_date` datetime DEFAULT NULL COMMENT '프로모션 시작일 ',
                         `promotion_end_time` datetime DEFAULT NULL COMMENT '프로모션 종료시간',
                         `location_type` varchar(50) DEFAULT NULL COMMENT '지역',
                         `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                         `reg_idx` int DEFAULT NULL COMMENT '등록자 식별자 번호',
                         `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                         `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호',
                         PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상점'


--

CREATE TABLE `store_amenity` (
                                 `idx` int NOT NULL AUTO_INCREMENT COMMENT '식별자 번호 ',
                                 `store_idx` int NOT NULL COMMENT '상점 식별자 번호',
                                 `amenity_idx` int NOT NULL COMMENT '편의시설 식별자 번호',
                                 `reg_datetime` datetime NOT NULL COMMENT '등록일시',
                                 `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호',
                                 `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                                 `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호 ',
                                 PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상점 편의시설 '


--

CREATE TABLE `store_reserve_information` (
                                             `idx` int DEFAULT NULL COMMENT '예약 메타 데이터 식별자 번호',
                                             `reserve_price` int NOT NULL COMMENT '예약금',
                                             `reserve_type` varchar(50) NOT NULL COMMENT '예약타입(PERSON(인당),TABLE(테이블당))',
                                             `min_user_count` int NOT NULL COMMENT '최소 인원',
                                             `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                                             `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호',
                                             `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                                             `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상점 예약 정보'

--

CREATE TABLE `store_reserve_data` (
                                      `idx` int NOT NULL AUTO_INCREMENT COMMENT '상점 예약 데이터 식별자 번호',
                                      `store_idx` int NOT NULL COMMENT '상점 식별자 번호',
                                      `reserve_date` date NOT NULL COMMENT '예약일',
                                      `reserve_time` int NOT NULL COMMENT '예약 시간 ex) 1320(1시20분), 1520(15시20분)',
                                      `min_user_count` int NOT NULL DEFAULT '2' COMMENT '최소인원',
                                      `max_user_count` int NOT NULL DEFAULT '9' COMMENT '최대인원',
                                      `reserve_count` int NOT NULL COMMENT '예약횟수',
                                      `status` varchar(50) NOT NULL COMMENT '예약 데이터 상태(예약 대기, 활성화)',
                                      `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                                      `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호',
                                      `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                                      `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호',
                                      PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상점  예약 데이터'


--

CREATE TABLE `store_waiting` (
                                 `idx` int NOT NULL AUTO_INCREMENT COMMENT '상점 웨이팅 식별자 번호',
                                 `store_idx` int NOT NULL COMMENT '상점 식별자 번호',
                                 `status` varchar(10) NOT NULL COMMENT '활성화 여부 (active:활성화, inactive:마감 또는 비활성화)',
                                 `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                                 `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호 ',
                                 `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                                 `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호 ',
                                 PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상점 웨이팅 정보'


--
CREATE TABLE `user` (
                        `idx` int NOT NULL AUTO_INCREMENT COMMENT '유저 식별자 번호',
                        `email` varchar(50) NOT NULL COMMENT '이메일',
                        `password` varchar(255) NOT NULL COMMENT '비밀번호',
                        `phone` varchar(255) NOT NULL COMMENT '핸드폰번호',
                        `nickname` varchar(50) NOT NULL COMMENT '닉네임',
                        `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                        `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                        PRIMARY KEY (`idx`),
                        UNIQUE KEY `user_pk_2` (`email`),
                        UNIQUE KEY `user_pk_3` (`nickname`),
                        UNIQUE KEY `user_pk` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='유저정보'

--

CREATE TABLE `user_reseve_data` (
                                    `idx` int NOT NULL AUTO_INCREMENT COMMENT '유저 예약 데이터 식별자 번호',
                                    `user_idx` int NOT NULL COMMENT '유저 식별자 번호',
                                    `reserve_data_idx` int NOT NULL COMMENT '예약데이터 식별자 번호',
                                    `reserve_status` varchar(50) NOT NULL COMMENT '예약상태(등록,취소,결제 대기, 완료)',
                                    `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                                    `reg_idx` int NOT NULL COMMENT '등록자 식별자 번호',
                                    `mod_datetime` datetime DEFAULT NULL COMMENT '수정일시',
                                    `mod_idx` int DEFAULT NULL COMMENT '수정자 식별자 번호',
                                    PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='유저 예약 정보'

--

CREATE TABLE `user_waiting` (
                                `idx` int DEFAULT NULL COMMENT '유저 웨이팅 식별자 번호 ',
                                `store_waiting_idx` int NOT NULL COMMENT '상점 웨이팅 식별자 번호',
                                `user_type` varchar(10) DEFAULT NULL COMMENT '유저타입(회원(APP_USER),비회원(BASIC)',
                                `user_idx` varchar(50) NOT NULL COMMENT '유저타입(회원이면 식별자번호, 비회원이면 핸드폰번호)',
                                `status` varchar(50) NOT NULL COMMENT '웨이팅 상태(등록(register)/취소(cance)/완료(success)/만료(expire))',
                                `waiting_date` date NOT NULL COMMENT '대기일시',
                                `waiting_type` varchar(50) NOT NULL COMMENT '웨이팅 요청 타입(앱/매장)',
                                `reg_datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일시',
                                KEY `user_waiting_waiting_date_store_waiting_idx_index` (`waiting_date`,`store_waiting_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='유저 웨이팅 정보'
