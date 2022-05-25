package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {
	
	//フィールド
	private Connection con;
	private static final String SQL_SELECT_ALL = "SELECT * FROM products order by product_id";
	private static final String SQL_INSERT = "INSERT INTO products(product_name, price) VALUES(?, ?)";
	
	//コンストラクタ
	public ProductDao(Connection con) {
		this.con = con;
	}
	

	public List<Product> findAll() {
	    List<Product> list = new ArrayList<Product>();
	    	    
	    try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Product u = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
	            list.add(u);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }

	    return list;
	}
	
	//registerメソッド
	public void register(Product product) {
	    try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {
	        stmt.setString(1, product.getProductName());
	        stmt.setInt(2,product.getPrice());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


}
