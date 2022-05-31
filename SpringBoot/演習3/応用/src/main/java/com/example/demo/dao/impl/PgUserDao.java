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
    private static final String INSERT = "INSERT INTO product (product_name, price) VALUES(:name, :price)";
    private static final String SELECT_BY_PRICE ="SELECT * FROM product WHERE price = :price ORDER BY id";
    private static final String SELECT_BY_NAME_AND_PRICE ="SELECT * FROM product WHERE product_name = :name AND price = :price ORDER BY id";
    
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
    public List<Product> findByName(String name) {
        String sql = SELECT_BY_PRODUCT_NAME;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);

        return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public Product findById(int id) {
    	String sql = SELECT_BY_ID;
    	
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        List<Product> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));

        return resultList.isEmpty() ? null : resultList.get(0);
    }
    
    @Override
    public void insert(Product pd) {
    	String sql = INSERT;
    	
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("price", pd.getPrice());
        param.addValue("name", pd.getProduct_name());

        jdbcTemplate.update(sql, param);
    }
    
    @Override
    public List<Product> findByPrice(int price) {
    	String sql = SELECT_BY_PRICE;
    	
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("price", price);

        return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
    }
    
    @Override
    public List<Product> findByNamePrice(String name, int price) {
    	String sql = SELECT_BY_NAME_AND_PRICE;
    	
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", name);
        param.addValue("price", price);

        return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
    }
    
}

