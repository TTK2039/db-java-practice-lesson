package com.example.demo.controller;

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

    @RequestMapping({ "/", "/top" })
    public String index(@ModelAttribute("index") IndexForm form, Model model) {
    	List<Product> pd = pdService.findAll();
    	model.addAttribute("pd", pd);
        return "top";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@ModelAttribute("index") IndexForm form, Model model) {
        int id = form.getProduct_id();
        
        Product product = pdService.findById(id);
        
        model.addAttribute("product", product);
        
        return "result";
    }

}
