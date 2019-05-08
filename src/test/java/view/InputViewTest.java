package view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 플레이어_이름_입력() {
        //given
        InputStream inputStream = getInputStream("pinn, jake, mugi, conn");
        InputView inputView = new InputView(inputStream);
        //when
        //then
        assertThat(inputView.inputPlayerNames()).isEqualTo("pinn,jake,mugi,conn");
    }

    @Test
    public void 실행_결과_입력() {
        //given
        InputStream inputStream = getInputStream("꽝, 5000, 꽝, 3000");
        InputView inputView = new InputView(inputStream);
        //when
        //then
        assertThat(inputView.inputExecuteResult()).isEqualTo("꽝,5000,꽝,3000");

    }

    @Test
    public void 사다리_높이_입력() {
        //given
        InputStream inputStream = getInputStream("4");
        InputView inputView = new InputView(inputStream);
        //when
        //then
        assertThat(inputView.inputLadderHeight()).isEqualTo(4);
    }

    @Test
    public void 결과_원하는_사람_입력(){
        InputStream inputStream = getInputStream("conn");
        InputView inputView = new InputView(inputStream);
        //when
        //then
        assertThat(inputView.inputTargetPlayer()).isEqualTo("conn");
    }

    public InputStream getInputStream(String inputValue) {
        return new ByteArrayInputStream(inputValue.getBytes());
    }
}