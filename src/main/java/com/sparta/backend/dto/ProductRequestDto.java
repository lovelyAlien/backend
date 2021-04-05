package com.sparta.backend.dto;



import lombok.Getter;

@Getter
public class ProductRequestDto {

    private String name;

    private Integer price;

    private Integer num_faved;

    private Integer num_item_view;

    private Integer num_comment;

    private String user_name;

    private Long update_time;

    private Boolean free_shipping;

    private String profile_image;

    private String product_image;

    private String description;

    private String description_for_detail;

    private Boolean tradable;

    private Boolean used;

    private String location;

    private Integer qty;

    private String keyword;
}
