package com.shop.entity;

import com.shop.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item_img")
@Getter @Setter
public class ItemImg extends BaseEntity {

    @Id
    @Column(name = "item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName; // 이미지 파일명

    private String oriImageName; // 원본 이미지 파일명

    private String imgUrl; // 이미지 경로

    private String repimgYn; // 대표 이미지 존재 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void uploadItemImg(String oriImageName, String imgName, String imgUrl){
        this.oriImageName = oriImageName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
