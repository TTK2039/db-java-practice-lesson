package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductsDao;
import com.example.entity.Products;
import com.example.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsDao pdDao;

    public List<Products> findAll() {
        return pdDao.findAll();
    }
}
