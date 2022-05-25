package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.dao.ProductsDao;
import com.example.entity.Products;

@Repository
public class PgUserDao implements ProductsDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Products> findAll() {
        return jdbcTemplate.query("SELECT * FROM products",
            new BeanPropertyRowMapper<Products>(Products.class));
    }
}

