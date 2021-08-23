package com.spring.config.converters;

import com.spring.dao.model.Manufacturer;
import com.spring.dao.model.Product;
import com.spring.dto.ManufacturerDTO;
import com.spring.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ManufacturerConverter {

    public Manufacturer toManufacturer(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerDTO.getId());
        manufacturer.setName(manufacturerDTO.getName());
        Set<Product> products = manufacturerDTO.getProducts().stream()
                    .map(this::toProduct)
                    .collect(Collectors.toSet());
        manufacturer.setProducts(products);
        return manufacturer;
    }

    public ManufacturerDTO fromManufacturer(Manufacturer manufacturer) {
        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
        manufacturerDTO.setId(manufacturer. getId());
        manufacturerDTO.setName(manufacturer.getName());
        Set<ProductDTO> products = manufacturer.getProducts().stream()
                        .map(this::fromProduct)
                        .collect(Collectors.toSet());
        manufacturerDTO.setProducts(products);
        return manufacturerDTO;
    }

    private Product toProduct(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice());
    }

    private ProductDTO fromProduct(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(),
                product.getManufacturer().getId());
    }
}
