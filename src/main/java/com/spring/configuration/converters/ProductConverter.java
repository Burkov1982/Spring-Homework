package com.spring.configuration.converters;

import com.spring.dao.model.Manufacturer;
import com.spring.dao.model.Product;
import com.spring.dto.ManufacturerDTO;
import com.spring.dto.ProductDTO;
import com.spring.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    private final ManufacturerService service;

    @Autowired
    public ProductConverter(ManufacturerService service) {
        this.service = service;
    }

    public Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice(),
                toManufacturer(service.findById(productDTO.getManufacturerId())));
    }

    public ProductDTO fromProduct(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(),
                product.getManufacturer().getId());
    }

    private Manufacturer toManufacturer(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerDTO.getId());
        manufacturer.setName(manufacturerDTO.getName());
        return manufacturer;
    }
}
