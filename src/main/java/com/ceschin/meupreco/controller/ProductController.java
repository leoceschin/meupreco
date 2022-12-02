package com.ceschin.meupreco.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    
    @GetMapping("/manga/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/manga/{id}")
    public Product getProductByID(@PathVariable(value="id") UUID id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete-manga/{id}")
    public void deleteProductById(@PathVariable(value="id") UUID id){
        productService.deleteProductById(id);
    }
    

}
