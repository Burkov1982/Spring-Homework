package com.spring.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private UUID id;

    @Getter
    @Setter
    @Column(name = "product_name")
    private String name;

    @Getter
    @Setter
    @Column(name = "product_price")
    private BigDecimal price;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    public Product() {
    }

    public Product(UUID id, String product_name, BigDecimal product_price, Manufacturer manufacturer) {
        this.id = id;
        this.name = product_name;
        this.price = product_price;
        this.manufacturer = manufacturer;
    }

    public Product(UUID id, String product_name, BigDecimal product_price) {
        this.id = id;
        this.name = product_name;
        this.price = product_price;
    }
}
