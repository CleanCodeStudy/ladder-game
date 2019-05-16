package domain.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void 유저생성() {
        User user = new User("hello");
        assertEquals("hello", user.getName());
    }
}