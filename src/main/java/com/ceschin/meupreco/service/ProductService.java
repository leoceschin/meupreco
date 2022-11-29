package com.ceschin.meupreco.service;

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

}
