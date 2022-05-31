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
    
    String msg = "";
    
    @RequestMapping({ "/", "/top" })
    public String index(@ModelAttribute("index") IndexForm form, Model model) {
//    	List<Product> pd = pdService.findAll();
//    	model.addAttribute("pd", pd);
        return "top";
    }

    @RequestMapping(value = "/serch", method = RequestMethod.POST)
    public String result(@ModelAttribute("index") IndexForm form, Model model) {
    	String name = form.getProduct_name();
    	Integer price = form.getPrice();
    	
    	if(name.equals("") && price == null) {
    		List<Product> pd = pdService.findAll();
    		
    		model.addAttribute("list", pd);
            model.addAttribute("msg", "全件検索結果");
    	}else if (name.equals("")) {
    		List<Product> pd = pdService.findByPrice(price);
    		
    		model.addAttribute("list", pd);
    		model.addAttribute("msg", "値段で検索しました");
    		
    	}else if (price == null) {
    		List<Product> pd = pdService.findByName(name);
    		
    		model.addAttribute("list", pd);
    		model.addAttribute("msg", "名前で検索しました");
    	}else {
    		List<Product> pd = pdService.findByNamePrice(name, price);
    		
    		model.addAttribute("list", pd);
    		model.addAttribute("msg", "名前と値段のAND検索です");
    	}

        return "result";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String resgister(@ModelAttribute("index") IndexForm form, Model model) {
        //なんか違う気がする
        Product pd = new Product();
    	
    	pd.setPrice(form.getPrice());
        pd.setProduct_name(form.getProduct_name());
        
        pdService.insert(pd);
        
        model.addAttribute("msg", "登録されました");
        
        return "result";
    }

}
