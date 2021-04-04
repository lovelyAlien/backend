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
    private static String DATAS_URL="https://m.bunjang.co.kr/";

    @PostConstruct
    public void getDatas() throws IOException {
        try{
            Document doc = Jsoup.connect(DATAS_URL).get();

            System.out.println(doc);

//            Elements products = doc.select("ul.collection__products");
//            for(Element product : products.select("li.collection__product")){
//                String name = product.select("a.product-card__title").text();
//                String price = product.select("span.product-card__price").text();
//                System.out.println(name+price);
//            }

        } catch(IOException e){
            System.out.println("목록을 찾을 수 없습니다");
        }


    }

    @Transactional
    public List<ProductRequestDto> getProductList() {
        List<Product> productList = productRepository.findAll();
        List<ProductRequestDto> productDtoList = new ArrayList<>();

        for(Product product : productList) {
            ProductRequestDto productDto = ProductRequestDto.builder()
                    .pid(product.getPid())
                    .name(product.getName())
                    .product_image(product.getProduct_image())
                    .createdAt(product.getCreatedAt())
                    .modifiedAt(product.getModifiedAt())
                    .build();
           productDtoList.add(productDto);
        }
        return productDtoList;

    }


}
