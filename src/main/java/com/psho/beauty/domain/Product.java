package com.psho.beauty.domain;

import java.time.LocalDateTime;

/**
 * product 테이블 한 행을 담는 객체.
 * MyBatis 가 SELECT 결과의 컬럼(item_type)을 필드(itemType)에 자동으로 채운다.
 */
public class Product {

    private Long id;
    private String name;
    private Integer price;
    private String imageFile;
    private String description;
    private String itemType;      // 쿠션/파운데이션/립/아이
    private String category;      // 베이스/색조
    private String skinType;      // 베이스 제품만
    private String personalColor; // 색조 제품만
    private Integer shadeNo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public String getImageFile() { return imageFile; }
    public void setImageFile(String imageFile) { this.imageFile = imageFile; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSkinType() { return skinType; }
    public void setSkinType(String skinType) { this.skinType = skinType; }

    public String getPersonalColor() { return personalColor; }
    public void setPersonalColor(String personalColor) { this.personalColor = personalColor; }

    public Integer getShadeNo() { return shadeNo; }
    public void setShadeNo(Integer shadeNo) { this.shadeNo = shadeNo; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
