package domain.user;

import data.InputData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserManageTest {

    @Test
    public void 유저_리스트_관리하는_유저_관리자_생성하기() {
        InputData inputData = new InputData("pobi,honux,crong,jk", 4);
        UserManage userManage = new UserManage(inputData);
        assertEquals(4, userManage.getUsers().size());
    }
}