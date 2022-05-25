package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.User;
import util.DbUtil;

public class UserDaoTest {

    private Connection connection;
    private UserDao userDao;

    @BeforeEach
    public void setUp() throws Exception {
        connection = DbUtil.getConnection();
        connection.setAutoCommit(false);

        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM users")) {
            stmt.executeUpdate();
        }

        try (Statement stmt = connection.createStatement()) {
            stmt.addBatch("INSERT INTO users VALUES (1, 'Alice', 'alice@axiz.co.jp', 'axiz')");
            stmt.addBatch("INSERT INTO users VALUES (2, 'Bob', 'bob@axiz.co.jp', 'axiz')");
            stmt.executeBatch();
        }

        userDao = new UserDao(connection);
    }

    @AfterEach
    public void tearDown() throws Exception {
        connection.rollback();
    }

    @Test
    public void findAllで全件取得できる() {
        List<User> list = userDao.findAll();
        assertEquals(2, list.size());

        User u = list.get(0);
        assertEquals(Integer.valueOf(1), u.getId());
        assertEquals("Alice", u.getName());
        assertEquals("alice@axiz.co.jp", u.getMail());
        assertEquals("axiz", u.getPass());

        u = list.get(1);
        assertEquals(Integer.valueOf(2), u.getId());
        assertEquals("Bob", u.getName());
        assertEquals("axiz", u.getPass());
    }

    @Test
    public void findAllはデータがないと空のリストを返す() throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM users")) {
            stmt.executeUpdate();
        }

        List<User> list = userDao.findAll();
        assertEquals(0, list.size());
    }

    @Test
    public void findByIdで存在するデータが正しく取得できる() {
        User user = userDao.findById(1);
        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals("Alice", user.getName());
        assertEquals("alice@axiz.co.jp", user.getMail());
        assertEquals("axiz", user.getPass());
    }

    @Test
    public void findByIdで存在しないデータはnullになる() {
        User user = userDao.findById(10);
        assertNull(user);
    }

    @Test
    public void insertでデータを登録できる() {
        User newUser = new User(10, "taro", "taro@gmail.com", "password");
        userDao.insert(newUser);

        User getUser = userDao.findById(10);
        assertEquals(newUser.getId(), getUser.getId());
        assertEquals(newUser.getName(), getUser.getName());
        assertEquals(newUser.getMail(), getUser.getMail());
    }

    @Test
    public void insertで主キーが重複していると例外発生() {
        User newUser = new User(1, "taro", "taro@gmail.com", "password");
        assertThrows(RuntimeException.class, () -> userDao.insert(newUser));
    }

    @Test
    public void updateでデータを更新できる() {
        User user = userDao.findById(1);
        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals("Alice", user.getName());
        assertEquals("alice@axiz.co.jp", user.getMail());

        user.setName("佐藤");
        userDao.update(user);

        user = userDao.findById(1);
        assertEquals(Integer.valueOf(1), user.getId());
        assertEquals("佐藤", user.getName());
        assertEquals("alice@axiz.co.jp", user.getMail());
    }

    @Test
    public void deleteでデータを削除できる() {
        User user = userDao.findById(1);
        assertNotNull(user);

        userDao.delete(1);

        user = userDao.findById(1);
        assertNull(user);
    }

}
