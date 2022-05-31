package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductDao {

    public List<Product> findAll();
	
    public Product findByName(String name);

    public Product findById(int id);
    
}

