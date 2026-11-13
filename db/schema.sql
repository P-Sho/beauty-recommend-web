-- 뷰티 추천 웹 서비스 스키마 (MySQL 8.0)
-- 실행: mysql -u root -p -P 3308 < db/schema.sql   (그다음 data.sql)

CREATE DATABASE IF NOT EXISTS beauty
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE beauty;

DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL COMMENT '제품명',
    price          INT          NOT NULL COMMENT '가격(원)',
    image_file     VARCHAR(150)          COMMENT '원본 이미지 파일명',
    description    VARCHAR(255)          COMMENT '제품 설명',
    item_type      VARCHAR(20)  NOT NULL COMMENT '제품 종류: 쿠션/파운데이션/립/아이',
    category       VARCHAR(20)  NOT NULL COMMENT '분류: 베이스/색조',
    skin_type      VARCHAR(20)           COMMENT '베이스 제품만: 건성/지성/민감성',
    personal_color VARCHAR(20)           COMMENT '색조 제품만: 봄웜/여름쿨/가을웜/겨울쿨',
    shade_no       INT                   COMMENT '원본 number 컬럼(베이스 제품만 20~23 값) - 의미 확인 필요',
    created_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB COMMENT='화장품 (smartmirror cosmetics.db 이관)';

-- TODO(3주차): 검색 조건 컬럼에 인덱스를 추가하고 EXPLAIN 전후를 비교해 README에 기록
