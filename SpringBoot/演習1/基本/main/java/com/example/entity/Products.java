package com.example.entity;

public class Products {
    private Integer product_id;
    private String product_name;
    private Integer price;
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
    public String getProductsInfo() {
        return "product_id=" + product_id + ", product_name=" + product_name + ", price=" + price;
    }
}
