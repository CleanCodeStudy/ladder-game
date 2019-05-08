package domain;

import domain.Bridge;
import domain.Point;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @Test
    public void 첫번째_브릿지_생성하기() {
        //given
        Integer height = 1;
        Point leftPoint = Point.createRightLinkedPoint(1);
        Point rightPoint = Point.createLeftLinkedPoint(2);
        Bridge firstBridge = new Bridge(height, Arrays.asList(leftPoint,rightPoint));
        //when
        //then
        assertEquals(firstBridge.nextPoint(1).getColumn(),rightPoint.getColumn());
        assertEquals(firstBridge.nextPoint(2).getColumn(),leftPoint.getColumn());
    }

    @Test
    public void 첫번쨰_브릿지_연결안된거() {
        //given
        //when
        //then
    }

    @Test
    public void 고정된_브릿지_생성하기() {
//        //given
//        int height = 1;
//        int playerNumber = 3;
//        Bridge firstBridge = Bridge.createFixedBridge(height,playerNumber);
//        Point firstPoint = Point.createRightLinkedPoint(1);
//        Point secondPoint = Point.createLeftLinkedPoint(2);
//        Point thridPoint = Point.createNotLinkedPoint(3);
//        //when
//        //then
//        assertThat(firstBridge.nextPoint(1).getColumn()).isEqualTo(secondPoint.getColumn());
    }
}