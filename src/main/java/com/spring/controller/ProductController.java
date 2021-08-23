package com.spring.controller;

import com.spring.dto.ManufacturerDTO;
import com.spring.dto.ProductDTO;
import com.spring.service.ManufacturerService;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService service;
    private final ManufacturerService manufacturerService;

    @Autowired
    public ProductController(ProductService service, ManufacturerService manufacturerService) {
        this.service = service;
        this.manufacturerService = manufacturerService;
    }

    //Get logic
    @GetMapping(path = "/findProductByManufacturerId")
    public ModelAndView showProductsByManufacturerIdPage(@RequestParam(name =  "id")UUID uuid, ModelAndView model) {
        List<ProductDTO> products = service.getProductByManufacturerId(uuid);
        ManufacturerDTO manufacturerDTO = manufacturerService.findById(uuid);
        model.addObject("products", products);
        model.addObject("manufacturer", manufacturerDTO);
        model.setViewName("findProductsByManufacturerId");
        return model;
    }

    @GetMapping(path = "/findProductById")
    public ModelAndView showProductById (@RequestParam(name = "id") UUID uuid, ModelAndView model) {
        ProductDTO product = service.findById(uuid);
        ManufacturerDTO manufacturer = manufacturerService.findById(product.getManufacturerId());
        model.addObject("product", product);
        model.addObject("manufacturer", manufacturer);
        model.setViewName("findProductById");
        return model;
    }

    @GetMapping(path = "/findAllProducts")
    public ModelAndView showFindAllProductsPage(ModelAndView model) {
        List<ProductDTO> products = service.getAll();
        model.addObject("products", products);
        model.setViewName("findAllProducts");
        return model;
    }
}
