package com.sparta.backend.service;

import com.sparta.backend.dto.ProductRequestDto;
import com.sparta.backend.model.Product;
import com.sparta.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;



    @Transactional
    public List<ProductRequestDto> searchProducts(String keyword){
        List<Product> products= productRepository.findByNameContaining(keyword);
        List <ProductRequestDto> productRequestDtoList = new ArrayList<>();
        if(products.isEmpty()) return productRequestDtoList;

        for(Product product : products){
            productRequestDtoList.add(this.convertEntityToDto(product));
        }
        return productRequestDtoList;
    }

    private ProductRequestDto convertEntityToDto(Product product){
        return ProductRequestDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .num_faved(product.getNum_faved())
                .num_item_view(product.getNum_item_view())
                .num_comment(product.getNum_comment())
                .user_name(product.getUser_name())
                .update_time(product.getUpdate_time())
                .free_shipping(product.getFree_shipping())
                .profile_image(product.getProfile_image())
                .product_image(product.getProduct_image())
                .description(product.getDescription())
                .description_for_detail(product.getDescription_for_detail())
                .tradable(product.getTradable())
                .used(product.getUsed())
                .location(product.getLocation())
                .qty(product.getQty())
                .keyword(product.getKeyword())
                .build();
    }

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Product createProduct(ProductRequestDto requestDto, Long userId ) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);
        productRepository.save(product);
        return product;
    }

}
