package com.spring.controller;

import com.spring.config.converters.ProductConverter;
import com.spring.dto.ManufacturerDTO;
import com.spring.dto.ProductDTO;
import com.spring.service.ManufacturerService;
import com.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService service;
    private final ManufacturerService manufacturerService;
    private final ProductConverter productConverter;

    @Autowired
    public ProductController(ProductService service, ManufacturerService manufacturerService, ProductConverter productConverter) {
        this.service = service;
        this.manufacturerService = manufacturerService;
        this.productConverter = productConverter;
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

    //Add, update, delete logic
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam("id") UUID uuid){
        ProductDTO product = service.findById(uuid);
        service.delete(product);
        return new RedirectView("/products/findAllProducts");
    }

    @GetMapping(path = "/form/add")
    public String showAddProductPage(Model model) {
        List<ManufacturerDTO> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "addProductForm";
    }

    @PostMapping(path = "/addProduct")
    public RedirectView add(@ModelAttribute("product") ProductDTO product) {
        service.saveOrUpdate(product);
        return new RedirectView("/products/findAllProducts");
    }

    @GetMapping(path = "/form/update")
    public String showUpdateProductPage(@RequestParam("id") UUID uuid, Model model) {
        ProductDTO productDTO = service.findById(uuid);
        model.addAttribute("product", productDTO);
        return "updateProductForm";
    }

    @PostMapping(path = "/updateProduct")
    public RedirectView update(@ModelAttribute("product") ProductDTO productDTO) {
        service.saveOrUpdate(productDTO);
        return new RedirectView("/products/findAllProducts");
    }

    @ModelAttribute(name = "product")
    public ProductDTO defaultProduct(){
        return new ProductDTO();
    }
}
