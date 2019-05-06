package dto;

import domain.ladder.TopAndBottom;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputDtoTest {
    String names;
    int height;
    String rewards;

    @Before
    public void setUp() {
        names = "pobi,honux,crong,jk";
        height = 5;
        rewards = "꽝,5000,꽝,3000";
    }

    @Test
    public void 입력받은_이름을_리스트로_나누기() {

        UserInputDto userInputDto = new UserInputDto(names, height, rewards);
        assertThat(userInputDto.getNames()).contains("pobi", "honux", "crong", "jk");
    }

    @Test
    public void 입력받은_이름_결과값_으로_유저객체_생성하기() {
        String names = "pobi,honux,crong,jk";
        UserInputDto userInputDto = new UserInputDto(names, height, rewards);

        List<String> collectNames = Arrays.asList(names.split(","));
        List<TopAndBottom> topAndBottoms = userInputDto.toEntities();

        assertThat(topAndBottoms.size()).isEqualTo(4);
        for (int i = 0; i < topAndBottoms.size(); i++) {
            assertThat(topAndBottoms.get(i).getUser()).contains(collectNames.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void 두명미만_참여_익셉션() {
        String names = "pobi,honux,crong,jk";
        UserInputDto userInputDto = new UserInputDto(names, height, rewards);

        names = "pobi";
        userInputDto = new UserInputDto(names, height, rewards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이_1미만_입력() {
        String names = "pobi,honux,crong,jk";

        UserInputDto userInputDto = new UserInputDto(names, height, rewards);
        userInputDto = new UserInputDto(names, 0, rewards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 인원수와_결과값_갯수의_불일치() {
        rewards = "5000,3000";
        UserInputDto userInputDto = new UserInputDto(names, height, rewards);
    }
}