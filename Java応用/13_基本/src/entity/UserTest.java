package entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void usersテーブルに対応している() {
        User user = new User();
        user.setId(10);
        user.setName("test");
        user.setMail("test@test.com");
        user.setPass("password");

        assertEquals(Integer.valueOf(10), user.getId());
        assertEquals("test", user.getName());
        assertEquals("test@test.com", user.getMail());
        assertEquals("password", user.getPass());
    }

    @Test
    public void 引数のあるコンストラクターがある() {
        User user = new User(10, "test", "test@test.com", "password");

        assertEquals(Integer.valueOf(10), user.getId());
        assertEquals("test", user.getName());
        assertEquals("test@test.com", user.getMail());
        assertEquals("password", user.getPass());
    }

}
