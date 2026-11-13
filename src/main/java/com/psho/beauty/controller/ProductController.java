package com.psho.beauty.controller;

import com.psho.beauty.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * [3단계 흐름의 맨 위] 브라우저 요청을 받는 계층.
 * 요청 → Controller → Service → Mapper(SQL) → DB, 결과는 반대로 올라와 Model 에 담겨 화면으로 간다.
 */
@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products/list"; // → templates/products/list.html
    }

    // TODO(1주차): @GetMapping("/products/{id}") 상세 화면
}
