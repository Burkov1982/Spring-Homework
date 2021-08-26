package com.spring.service;

import com.spring.configuration.converters.ProductConverter;
import com.spring.dao.ProductRepository;
import com.spring.dao.model.Product;
import com.spring.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productConverter::fromProduct)
                .collect(Collectors.toList());
    }

    public ProductDTO findById (UUID uuid) {
        Optional<Product> product = productRepository.findById(uuid);
        return product.map(productConverter::fromProduct)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    public void save (ProductDTO productDTO) {
        Product product = productConverter.toProduct(productDTO);
        productRepository.save(product);
    }

    public void update (ProductDTO productDTO) {
        Product product = productConverter.toProduct(productDTO);
        productRepository.save(product);
    }

    public void delete (ProductDTO productDTO) {
        Product product = productConverter.toProduct(productDTO);
        productRepository.delete(product);
    }

    public List<ProductDTO> getProductByManufacturerId (UUID uuid) {
        List<Product> products = productRepository.getByManufacturerId(uuid);
        return products.stream()
                .map(productConverter::fromProduct)
                .collect(Collectors.toList());
    }
}
