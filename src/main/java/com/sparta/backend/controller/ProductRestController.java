package com.sparta.backend.controller;
import com.sparta.backend.model.Product;
import com.sparta.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductRepository productRepository;



    @GetMapping("/")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }



    @GetMapping("/api/products/{pid}")
    public Product getDetail(@PathVariable Long pid) {
        return productRepository.findById(pid).orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
