package com.sparta.backend.model;
import com.sparta.backend.dto.ProductRequestDto;
import lombok.Builder;
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

    @Column(nullable = false)
    private Long uid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer num_faved;

    @Column(nullable = false)
    private Integer num_item_view;

    @Column(nullable = false)
    private Integer num_comment;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private Long update_time;

    @Column(nullable = false)
    private Boolean free_shipping;

    @Column(nullable = false)
    private String profile_image;

    @Column(nullable = false)
    private String product_image;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description_for_detail;

    @Column(nullable = false)
    private Boolean tradable;

    @Column(nullable = false)
    private Boolean used;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private String keyword;

    public Product(ProductRequestDto requestDto , Long uid) {
        this.uid = uid;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
        this.num_faved= requestDto.getNum_faved();
        this.num_item_view=requestDto.getNum_item_view();
        this.num_comment=requestDto.getNum_comment();
        this.user_name=requestDto.getUser_name();
        this.update_time=requestDto.getUpdate_time();
        this.free_shipping=requestDto.getFree_shipping();
        this.profile_image=requestDto.getProfile_image();
        this.product_image=requestDto.getProduct_image();
        this.description=requestDto.getDescription();
        this.description_for_detail=requestDto.getDescription_for_detail();
        this.tradable=requestDto.getTradable();
        this.used=requestDto.getUsed();
        this.location=requestDto.getLocation();
        this.qty= requestDto.getQty();
        this.keyword=requestDto.getKeyword();
    }



}
