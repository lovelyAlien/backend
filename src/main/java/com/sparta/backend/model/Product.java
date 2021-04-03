package com.sparta.backend.model;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;

//    @Column(nullable = false)
//    private Long uid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

//    @Column(nullable = false)
//    private String username;

//    @Column(nullable = false)
//    private String profile_image;

    @Column(nullable = false)
    private String product_image;

//    @Column(nullable = false)
//    private String description;

//    @Column(nullable = false)
//    private String description_for_detail;

//    @Column(nullable = false)
//    private String location;

//    @Column(nullable = false)
//    private String keyword;
    @Builder
    public Product(String name, Long price, String product_image){
        this.name = name;
        this.price=price;
        this.product_image=product_image;
    }


}
