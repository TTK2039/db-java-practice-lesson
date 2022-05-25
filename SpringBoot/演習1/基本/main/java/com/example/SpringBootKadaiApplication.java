package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.entity.Products;
import com.example.service.ProductsService;

@SpringBootApplication
public class SpringBootKadaiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
            SpringApplication.run(SpringBootKadaiApplication.class, args);

        ProductsService pdService = context.getBean(ProductsService.class);
        List<Products> list = pdService.findAll();
    	System.out.println("【products】");
        for (Products u : list) {
            System.out.println(u.getProductsInfo());
        }
    }

}

