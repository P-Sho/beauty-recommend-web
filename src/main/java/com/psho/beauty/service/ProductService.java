package com.psho.beauty.service;

import com.psho.beauty.domain.Product;
import com.psho.beauty.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * [3단계 흐름의 가운데] 업무 규칙을 담는 계층.
 * Controller 는 화면/요청만, Mapper 는 SQL 만 담당하고 "판단"은 여기서 한다.
 * (예: 없는 제품을 찾으면 예외를 던진다 → 3주차 전역 예외처리에서 사용)
 */
@Service
public class ProductService {

    private final ProductMapper productMapper;

    // 생성자 주입: 스프링이 ProductMapper 구현체를 넣어 준다
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getProducts() {
        return productMapper.findAll();
    }

    // TODO(1주차): getProduct(Long id) — 결과가 null 이면 어떻게 할지 정하기
}
