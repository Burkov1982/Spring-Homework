package com.spring.dto;

import java.util.Set;
import java.util.UUID;

public class ManufacturerDTO {
    private UUID id;

    private String name;

    Set<ProductDTO> products;

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(UUID id, String manufacturer_name, Set<ProductDTO> products) {
        this.id = id;
        this.name = manufacturer_name;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Manufacturer UUID: "+id+"\n Manufacturer name: "+name;
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

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }
}
