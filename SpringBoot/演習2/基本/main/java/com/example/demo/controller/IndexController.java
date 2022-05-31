package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.controller.form.IndexForm;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class IndexController {

    @Autowired
    ProductService pdService;

    @RequestMapping({ "/", "/index" })
    public String index(@ModelAttribute("index") IndexForm form, Model model) {
    	List<Product> pdList = new ArrayList<>();
    	pdList.add(new Product(101, "鉛筆", 50));
    	pdList.add(new Product(101, "鉛筆", 50));
    	model.addAttribute("productList", pdList);
        return "index";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@ModelAttribute("index") IndexForm form, Model model) {
        String name = form.getName();
        String pdName = form.getProduct_name();
        Product product = null;
        
        if (pdName.equals("鉛筆")){
        	product = new Product(101, "鉛筆", 50);
        }else if(pdName.equals("消しゴム")){
        	product = new Product(102, "消しゴム", 100);
        }
        
        model.addAttribute("userName", name);
        model.addAttribute("product", product);
        
        return "result";
    }

}
