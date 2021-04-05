package com.sparta.backend.controller;


import com.sparta.backend.dto.ProductRequestDto;
import com.sparta.backend.model.Product;
import com.sparta.backend.repository.ProductRepository;
import com.sparta.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;


    @GetMapping("/")
    public List<Product> getProducts(){
//        List<ProductRequestDto> productDtoList = productService.getProductList();
//        return productDtoList;
        return productRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/products/{pid}")
    public Product getDetail(@PathVariable Long pid) {
        return productRepository.findById(pid).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
