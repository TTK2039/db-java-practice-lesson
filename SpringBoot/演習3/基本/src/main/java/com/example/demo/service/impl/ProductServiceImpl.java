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

    public List<Product> findAll() {
    	return pdDao.findAll();
    }
    
    public Product findByName(String name) {
        return pdDao.findByName(name);
    }
    
    public Product findById(int id ) {
    	return pdDao.findById(id);
    }
    
}

