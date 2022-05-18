package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {
	
	private Connection con;
	private static final String SQL_SELECT_ALL = "SELECT id, name, mail, pass FROM users ORDER BY id";
	private static final String SQL_SELECT_WHERE_USER_ID = "SELECT id, name, mail, pass FROM users WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO users (id, name, mail, pass) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE users SET name = ?, mail = ?, pass = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM users WHERE id = ?";

	public UserDao(Connection con) {
		this.con = con;
	}

	public List<User> findAll() {
	    List<User> list = new ArrayList<User>();
	    
	    
	    
	    try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("mail"), rs.getString("pass"));
	            list.add(u);
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }

	    return list;
	}


	public User findById(int userId) {
	    try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_WHERE_USER_ID)) {
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("mail"), rs.getString("pass"));
	        }
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }

	    return null;
	}


	public int insert(User user) {
	    try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {
	        stmt.setInt(1, user.getId());
	        stmt.setString(2, user.getName());
	        stmt.setString(3, user.getMail());
	        stmt.setString(4, user.getPass());

	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public int update(User user) {
	    try (PreparedStatement stmt = con.prepareStatement(SQL_UPDATE)) {
	        stmt.setString(1, user.getName());
	        stmt.setString(2, user.getMail());
	        stmt.setString(3, user.getPass());
	        stmt.setInt(4, user.getId());

	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


	public int delete(int userId) {
	    try (PreparedStatement stmt = con.prepareStatement(SQL_DELETE)) {
	        stmt.setInt(1, userId);

	        return stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


}
