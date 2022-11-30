package com.ceschin.meupreco.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceschin.meupreco.Dto.ProductDto;
import com.ceschin.meupreco.model.Product;
import com.ceschin.meupreco.repository.ProductRepository;
import com.ceschin.meupreco.scrapy.MyWebClient;

@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(ProductDto productDto){
        MyWebClient myWebClient = new MyWebClient();
        Product product = myWebClient.getProductFromUrl(productDto.getSearchUrl());
        
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(UUID id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct.get();
        return product;

    }

    public void deleteProductById(UUID id){
        productRepository.deleteById(id);
        
    }

}
