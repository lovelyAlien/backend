package com.sparta.backend.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductRequestDto {

    private Long pid;

    private String name;


    private Long price;


//    private String username;


//    private String profile_image;


    private String product_image;


//    private String description;


//    private String description_for_detail;


//    private String location;


//    private String keyword;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @Builder
    public ProductRequestDto(Long pid, String name, Long price, String product_image, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.pid = pid;
        this.name = name;
        this.price=price;
        this.product_image=product_image;
        this.createdAt=createdAt;
        this.modifiedAt=modifiedAt;
    }

}
