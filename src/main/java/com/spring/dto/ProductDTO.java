package com.spring.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO {
    private UUID id;

    private String name;

    private BigDecimal price;

    private UUID manufacturerId;

    public ProductDTO(UUID id, String product_name, BigDecimal product_price, UUID manufacturerId) {
        this.id = id;
        this.name = product_name;
        this.price = product_price;
        this.manufacturerId = manufacturerId;
    }

    public ProductDTO() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UUID getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(UUID manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
