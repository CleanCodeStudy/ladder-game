package domain.user;

import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParticipantUsersTest {

    @Test
    public void 유저_리스트_관리하는_유저_관리자_생성하기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4);
        ParticipantUsers participantUsers = new ParticipantUsers(gameStartOption);
        assertEquals(4, participantUsers.getUsers().size());
    }
}