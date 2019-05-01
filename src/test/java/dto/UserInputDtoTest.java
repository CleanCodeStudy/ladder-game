package dto;

import domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputDtoTest {
    String names;
    int height;

    @Before
    public void setUp() {
        names = "pobi,honux,crong,jk";
        height = 5;
    }

    @Test
    public void 입력받은_이름을_리스트로_나누기() {

        UserInputDto userInputDto = new UserInputDto(names, height);
        assertThat(userInputDto.getNames()).contains("pobi", "honux", "crong", "jk");
    }

    @Test
    public void 입력받은_이름으로_유저객체_생성하기() {
        String names = "pobi,honux,crong,jk";
        UserInputDto userInputDto = new UserInputDto(names, height);

        List<String> collectNames = Arrays.asList(names.split(","));
        List<User> users = userInputDto.toEntities();

        assertThat(users.size()).isEqualTo(4);
        for (int i = 0; i < users.size(); i++) {
            assertThat(users.get(i).getName()).contains(collectNames.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void 두명미만_참여_익셉션() {
        String names = "pobi,honux,crong,jk";
        UserInputDto userInputDto = new UserInputDto(names, height);

        names = "pobi";
        userInputDto = new UserInputDto(names, height);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이_1미만_입력(){
        String names = "pobi,honux,crong,jk";

        UserInputDto userInputDto = new UserInputDto(names, height);
        userInputDto = new UserInputDto(names, 0);
    }
}