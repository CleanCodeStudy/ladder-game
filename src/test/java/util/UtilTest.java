package util;

import domain.user.UserManage;
import org.junit.Test;
import util.Util;

import java.util.List;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void 랜덤_정수_리스트_생성() {
        List<Integer> b = Util.createRandomIntegers(3);
        assertEquals(true, b.size()<=3 && b.size()>=0);
    }


    @Test
    public void UserName_여러개로_분리하기() {
        String users = "pobi,honux,crong,jk";
        List<String> separateUserName = Util.separateUserName(users);
        assertEquals("pobi", separateUserName.get(0));
    }
}