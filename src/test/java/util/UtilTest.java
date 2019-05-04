package util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UtilTest {

    @Test
    public void 랜덤_정수_리스트_생성() {
        List<Integer> b = RandomIntegerMaker.createRandomIntegers(3);
        assertEquals(true, b.size() <= 3 && b.size() >= 0);
    }


    @Test
    public void UserName_여러개로_분리하기() {
        String users = "pobi,honux,crong,jk";
        List<String> separateUserName = RandomIntegerMaker.separateUserName(users);
        assertEquals("pobi", separateUserName.get(0));
    }
}