import data.InputData;
import domain.LinkedType;
import domain.Pillar;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PillarTest {
    @Test
    public void 오른쪽_기둥_연결_bridge_생성하기() {
    }

    @Test
    public void 왼쪽_기둥_연결_bridge_생성하기() {
    }

    @Test
    public void 첫번째기둥_넘버만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        assertEquals((Integer) 1, p.getPillarNum());
    }

    @Test
    public void 이전기둥확인해서_넘버만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        Pillar p2 = new Pillar(inputData, p);
        assertEquals((Integer) 2, p2.getPillarNum());
    }

    @Test
    public void 자동으로_오른쪽_기둥과_연결된_다리리스트_만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        assertEquals(true, p.getBridges().size() <= 3);
    }

    @Test
    public void 기둥에_연결된_다리의_location_값_리스트_가져오기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        List<Integer> bridgesLocations = p.getBridgesLocations();
        System.out.println(bridgesLocations);
        assertEquals(true, bridgesLocations.size() <= 3 && bridgesLocations.size() >= 0);
    }

    @Test
    public void 기둥에_연결된_특정_방향의_다리의_location_값_리스트_가져오기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        List<Integer> bridgesLocations = p.getBridgesDirectionLocation(LinkedType.LEFT);
        assertEquals(0, bridgesLocations.size());
    }


}