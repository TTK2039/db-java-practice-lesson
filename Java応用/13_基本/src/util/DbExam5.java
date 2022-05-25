package util;
import java.util.List;

import dao.ProductDao;
import entity.Product;

public class DbExam5 {

	public static void main(String[] args) {
		ProductDao pdDao = new ProductDao(DbUtil.getConnection());
		Product pd  = new Product(null, "ボールペン", 200);
		
		pdDao.register(pd);
		
		List<Product> productList = pdDao.findAll();
		
		for(Product product : productList) {
			System.out.println("product_id:" + product.getProductId() + ", product_name:" + product.getProductName() + ", price:" + product.getPrice());
		}
		
	}

}
