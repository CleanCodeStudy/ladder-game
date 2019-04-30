import data.InputDatas;
import domain.Pillar;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PillarTest {
    @Test
    public void 오른쪽_기둥_연결_bridge_생성하기() {
    }

    @Test
    public void 왼쪽_기둥_연결_bridge_생성하기() {
    }

    @Test
    public void 첫번째기둥_넘버만들기() {
        InputDatas inputDatas = new InputDatas(4,3);
        Pillar p = new Pillar(inputDatas, null);
        assertEquals((Integer)1, p.getPillarNum());
    }

    @Test
    public void 이전기둥확인해서_넘버만들기() {
        InputDatas inputDatas = new InputDatas(4,3);
        Pillar p = new Pillar(inputDatas, null);
        Pillar p2 = new Pillar(inputDatas, p);
        assertEquals((Integer)2, p2.getPillarNum());
    }

    @Test
    public void 오른쪽_기둥과_연결된_다리_리스트_출력하기() {
//        domain.Pillar p = new domain.Pillar()
    }

    @Test
    public void 랜덤확률로_오른쪽_기둥과_연결된_다리리스트_만들기() {

    }

    @Test
    public void 수동으로_오른쪽_기둥과_연결된_다리리스트_만들기() {
        Pillar p = new Pillar(Arrays.asList(true,false,true,false), null);
        assertEquals((Integer)0,p.getBridges().get(0).getLocation());
        assertEquals((Integer)2,p.getBridges().get(1).getLocation());
    }

    @Test
    public void 자동으로_오른쪽_기둥과_연결된_다리리스트_만들기() {
        InputDatas inputDatas = new InputDatas(4,3);
        Pillar p = new Pillar(inputDatas, null);
        assertEquals(true,p.getBridges().size()<3);
    }
}