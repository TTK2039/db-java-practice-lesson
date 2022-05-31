package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;

@Repository
public class PgUserDao implements ProductDao {

    private static final String SELECT_ALL = "SELECT * FROM product";
    private static final String SELECT_BY_PRODUCT_NAME = "SELECT * FROM product WHERE product_name = :name ORDER BY id";
    private static final String SELECT_BY_ID = "SELECT * FROM product WHERE id = :id ORDER BY id";
    
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    @Override
    public List<Product> findAll() {
    	String sql = SELECT_ALL;
    	
    	MapSqlParameterSource param = new MapSqlParameterSource();
       
        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList;
    }
    
    @Override
    public Product findByName(String name) {
        String sql = SELECT_BY_PRODUCT_NAME;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public Product findById(int id) {
    	String sql = SELECT_BY_ID;
    	
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
}

