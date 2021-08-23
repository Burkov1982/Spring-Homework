package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

public class ManufacturerDTO {
    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
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
}
