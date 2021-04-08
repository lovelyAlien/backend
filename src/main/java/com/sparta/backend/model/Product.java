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
    private Long userId;

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

    public Product(ProductRequestDto requestDto, Long userId){

        this.userId = userId;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
        this.product_image = requestDto.getProduct_image();
        this.description = requestDto.getDescription();
        this.qty = requestDto.getQty();
        this.tradable = requestDto.getTradable();
        this.location = requestDto.getLocation();
        this.used = requestDto.getUsed();


    }


}
