package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm;

    @Column(name="price", nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    private LocalDateTime regTime;  // 등록시간

    private LocalDateTime updateTime;  // 최종 수정 시간

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }
}
