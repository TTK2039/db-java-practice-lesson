package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {

    private static final String SQL_SELECT_PRODUCTID = "SELECT product_id, product_name, price FROM products WHERE product_id = ?";

    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public User findByProductId(String id) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_PRODUCTID)) {
        	
        	int idInt = Integer.parseInt(id);
        	
            stmt.setInt(1, idInt);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
