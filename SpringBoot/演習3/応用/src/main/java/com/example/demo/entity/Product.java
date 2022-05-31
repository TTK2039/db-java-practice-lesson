package com.example.demo.entity;

public class Product {
    private int id;
    private String product_name;
    private Integer price;
    //productName
    public Product() {
    	
    }
    
	public Product(int id, String product_name) {
		super();
		this.id = id;
		this.product_name = product_name;
	}

	public Product(int id, String product_name, Integer price) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
	}
	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return product_name;
	}

	public void setProductname(String product_name) {
		this.product_name = product_name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
