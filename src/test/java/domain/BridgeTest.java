package domain;

import domain.generator.PointGenerator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @Test
    public void 첫번째_브릿지_생성하기() {
        //given
        Integer height = 1;
        Point leftPoint = PointGenerator.createRightLinkedPoint(1);
        Point rightPoint = PointGenerator.createLeftLinkedPoint(2);
        Bridge firstBridge = new Bridge(height, Arrays.asList(leftPoint,rightPoint));
        //when
        //then
        assertEquals(firstBridge.nextPoint(1).getColumn(),rightPoint.getColumn());
        assertEquals(firstBridge.nextPoint(2).getColumn(),leftPoint.getColumn());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 연속으로_연결됬을경우_에러() {
        //given
        Integer height = 1;
        Point firstPoint = PointGenerator.createRightLinkedPoint(1);
        Point secondPoint = PointGenerator.createLeftLinkedPoint(2);
        Point thirdPoint = PointGenerator.createLeftLinkedPoint(3);
        //when
        //then
        Bridge bridge = new Bridge(height,Arrays.asList(firstPoint,secondPoint,thirdPoint));
    }
}