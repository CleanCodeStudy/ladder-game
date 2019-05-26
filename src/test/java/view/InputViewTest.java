package view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputViewTest {
    @Test
    public void 참가자_입력() {
        String purchase = "pobi,honux,crong,jk";
        InputStream purchaseInputStream = new ByteArrayInputStream(purchase.getBytes());
        InputView inputView = InputView.of(purchaseInputStream);
        assertEquals("pobi,honux,crong,jk", inputView.participants());
    }

    @Test
    public void 사다리_높이_입력() {
        String ladderHeight = "1";
        InputStream inputCorrectStringStream = new ByteArrayInputStream(ladderHeight.getBytes());
        InputView inputView = InputView.of(inputCorrectStringStream);
        assertEquals(1, inputView.ladderHeight());
    }
}