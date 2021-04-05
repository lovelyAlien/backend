package com.sparta.backend.controller;


import com.sparta.backend.dto.ProductRequestDto;
import com.sparta.backend.model.Product;
import com.sparta.backend.repository.ProductRepository;
import com.sparta.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductRestController {

    private final ProductRepository productRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    public ModelAndView detail() {
        ModelAndView modelAndView = new ModelAndView("detail");
        return modelAndView;
    }

    @GetMapping("/api/detail/{id}")
    public Product getDetail(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("null"));
    }
}
