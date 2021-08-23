package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO {
    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private UUID manufacturerId;

    public ProductDTO(UUID id, String product_name, BigDecimal product_price, UUID manufacturerId) {
        this.id = id;
        this.name = product_name;
        this.price = product_price;
        this.manufacturerId = manufacturerId;
    }
}
