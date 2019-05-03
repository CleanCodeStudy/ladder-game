package domain.user;

import data.InputData;
import domain.ladder.Pillar;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void 유저생성() {
        InputData inputData = new InputData("hello", 4);
        Pillar pillar = new Pillar(inputData, null);
        User user = new User("hello", pillar);
        assertEquals("hello", user.getName());
    }
}