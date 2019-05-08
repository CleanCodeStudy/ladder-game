package domain;

import domain.Point;
import org.junit.Test;
import util.LinkedType;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void 오른쪽_연결된_포인트_생성하기() {
        assertEquals(Point.createRightLinkedPoint(1).getLinkedType(), LinkedType.RIGHT);
    }

    @Test
    public void 왼쪽_연결된_포인트_생성하기() {
        assertEquals(Point.createLeftLinkedPoint(2).getLinkedType(),LinkedType.LEFT);
    }

    @Test
    public void 연결안된_포인트_생성하기() {
        assertEquals(Point.createNotLinkedPoint(1).getLinkedType(),LinkedType.NONE);
    }
}