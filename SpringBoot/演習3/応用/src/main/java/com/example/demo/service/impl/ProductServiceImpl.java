package com.example.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao pdDao;
    
    @Override
    public List<Product> findAll() {
    	return pdDao.findAll();
    }
    
    @Override
    public List<Product> findByName(String name) {
        return pdDao.findByName(name);
    }
    
    @Override
    public Product findById(int id ) {
    	return pdDao.findById(id);
    }
    
    @Override
    public void insert(Product pd) {
    	pdDao.insert(pd);
    }
    
    @Override
    public List<Product> findByPrice(int price) {
    	return pdDao.findByPrice(price);
    }
    
    @Override
    public List<Product> findByNamePrice(String name, int price) {
    	return pdDao.findByNamePrice(name, price);
    }
    
}

