package com.ceschin.meupreco.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceschin.meupreco.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
    
    
}
