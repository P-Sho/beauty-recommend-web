package com.psho.beauty.mapper;

import com.psho.beauty.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * [3단계 흐름의 맨 아래] DB와 대화하는 계층.
 * 인터페이스만 만들면 MyBatis 가 resources/mapper/ProductMapper.xml 의 SQL 과 연결해 구현체를 만든다.
 * (메서드 이름 = XML 의 id)
 */
@Mapper
public interface ProductMapper {

    List<Product> findAll();

    // TODO(1주차): 제품 상세 조회 — Product findById(Long id);
    // TODO(2주차): 조건 검색 + 페이징 — 동적 SQL(<where>, <if>) 연습
    // TODO(2주차): insert / update / delete
}
