package domain;

import domain.generator.PointGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void 오른쪽_연결된_포인트_생성하기() {
        assertEquals(PointGenerator.createRightLinkedPoint(1).getLinkedType(), LinkedType.RIGHT);
    }

    @Test
    public void 왼쪽_연결된_포인트_생성하기() {
        assertEquals(PointGenerator.createLeftLinkedPoint(2).getLinkedType(),LinkedType.LEFT);
    }

    @Test
    public void 연결안된_포인트_생성하기() {
        assertEquals(PointGenerator.createNotLinkedPoint(1).getLinkedType(),LinkedType.NONE);
    }

    @Test
    public void 컴럼_1_포인트_생성하기() {
        //given
        //when
        //then
        assertEquals(PointGenerator.createNotLinkedPoint(1).getColumn(),1);
    }
}