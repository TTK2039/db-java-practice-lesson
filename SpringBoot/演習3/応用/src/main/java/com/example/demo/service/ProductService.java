package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

    public List<Product> findAll();
	
    public List<Product> findByName(String name);
    
    public Product findById(int id);
    
    public void insert(Product pd);

    public List<Product> findByPrice(int price);
    
    public List<Product> findByNamePrice(String name, int price);
}