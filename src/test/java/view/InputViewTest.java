package view;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    InputView inputView;
    InputStream inputStream;

    @Before
    public void setUp() {
    }

    @Test
    public void 이름입력받기() {
        String names = "pobi,honux,crong,jk";
        inputStream = new ByteArrayInputStream(names.getBytes());
        inputView = new InputView(inputStream);
        assertThat(inputView.getNames()).isEqualTo(names);
    }

    @Test
    public void 사다리높이_입력() {
        String height = "5";
        inputStream = new ByteArrayInputStream(height.getBytes());
        inputView = new InputView(inputStream);
        assertThat(inputView.getHeight()).isEqualTo(Integer.valueOf(height));
    }

}