package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {

//    private static final String SQL_SELECT_PRODUCTID = "SELECT * FROM products WHERE product_id = ?";
//    private static final String SQL_SELECT_PRODUCTNAME = "SELECT * FROM products WHERE product_name = ?";
//    private static final String SQL_SELECT_PRODUCTIDNAME ="SELECT * FROM products WHERE product_id = ? AND product_name = ?";
//    private static final String SQL_FIND_ALL = "SELECT * FROM products ORDER BY product_id";
//    private static final String SQL_SUM_PRICE = "SELECT sum(price)  FROM products";
//    private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES(?, ?)";
//    private static final String SQL_DELETE_FROM_ID = "DELETE FROM products WHERE product_id = ?";
//    private static final String SQL_DELETE_FROM_NAME = "DELETE FROM products WHERE product_name=?";
   
    private static final String SQL_ALL_SELECT_TABLE = "SELECT p.product_id 商品ID, p.name 商品名, p.price 単価, c.name カテゴリ FROM products p JOIN categories c ON p.category_id = c.id";
    private static final String SQL_SELECT_BY_KEYWORD ="SELECT p.product_id 商品ID, p.name 商品名, p.price 単価, c.name カテゴリ FROM products p JOIN categories c ON p.category_id = c.id WHERE p.name LIKE ? OR c.name LIKE ?";
    private static final String SQL_INSERT = "INSERT INTO products (product_id, name, price, category_id, description) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM products WHERE product_id = ?";
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }
    
    public int productDelete(Product pd) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
    		stmt.setString(1, pd.getProduct_id());
    		return stmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return 0;
    	}
    }
    
    public int productInsert(Product pd) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
    		stmt.setString(1, pd.getProduct_id());
    		stmt.setString(2, pd.getName());
    		stmt.setInt(3, pd.getPrice());
    		stmt.setInt(4, pd.getCategory_id());
    		stmt.setString(5, pd.getDescription());
    		return stmt.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return 0;
    	}
    }
    
    
    public List<Product> allProducts( ) {
    	try (PreparedStatement stmt = connection.prepareStatement(SQL_ALL_SELECT_TABLE)) {
    		List<Product> list = new ArrayList<>();
            
    		ResultSet rs = stmt.executeQuery();

    		while (rs.next()) {
    			Product pd = new Product(rs.getString("商品id"), rs.getString("商品名"), rs.getInt("単価"), rs.getString("カテゴリ"));
    			list.add(pd);
    		}	
    		return list;
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public List<Product> selectByKeyword(String keyword) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_KEYWORD)) {
        	List<Product> list = new ArrayList<>();

            stmt.setString(1, "%"+ keyword + "%");
            stmt.setString(2, "%"+ keyword + "%");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product pd = new Product(rs.getString("商品id"), rs.getString("商品名"), rs.getInt("単価"), rs.getString("カテゴリ"));
                list.add(pd);
            }
            return list;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return null;
        }
    }
    
    
//    public Product findByProductId(String id) {
//        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_PRODUCTID)) {
//        	
//        	int idInt = Integer.parseInt(id);
//        	
//            stmt.setInt(1, idInt);
//
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
//    public Product findByProductIDandName(String id, String name) {
//        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_PRODUCTIDNAME)) {
//        	int idInt = Integer.parseInt(id);
//        	stmt.setInt(1, idInt);
//        	stmt.setString(2, name);
//
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
//            } else {
//                return null;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
    
    
//    public List<Product> findAll () {
//        List<Product> list = new ArrayList<>();
//    	
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_FIND_ALL)) {
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//            	Product  a =  new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
//                list.add(a);
//            }
//            return list;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
//    public int sumPrice () {
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_SUM_PRICE)) {
//
//            ResultSet rs = stmt.executeQuery();
//            int sum = 0;
//            while (rs.next()) {
//                sum = rs.getInt("sum");
//            }
//            return sum;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
//    public int registerchan (Product pd) {
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
//    		
//    		stmt.setString(1, pd.getProductName());
//    		stmt.setInt(2, pd.getPrice());
//    		
//            return  stmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
//    public int deleteFromID (Product pd) {
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_FROM_ID)) {
//    		
//    		stmt.setInt(1, pd.getProductId());
//    		
//            return  stmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
//    public int deleteFromName (Product pd) {
//    	try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_FROM_NAME)) {
//    		
//    		stmt.setString(1, pd.getProductName());
//    		
//            return  stmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

