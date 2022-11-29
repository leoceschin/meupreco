package com.ceschin.meupreco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceschin.meupreco.Dto.ProductDto;
import com.ceschin.meupreco.model.Product;
import com.ceschin.meupreco.service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;

    @PostMapping("/new-manga")
    public Product createManga(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

}
