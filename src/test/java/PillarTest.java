import data.InputData;
import domain.LinkedType;
import domain.Pillar;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PillarTest {

    @Test
    public void 첫번째기둥_넘버만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        assertEquals((Integer) 1, p.getPillarNum());
    }

    @Test
    public void 가운데기둥_넘버만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        Pillar p1 = new Pillar(inputData, p);

        assertEquals((Integer) 2, p1.getPillarNum());
    }

    @Test
    public void 마지막기둥_넘버만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);
        Pillar p1 = new Pillar(inputData, p);
        Pillar p2 = new Pillar(inputData, p1);
        Pillar p3 = new Pillar(inputData, p2);

        assertEquals((Integer) 4, p3.getPillarNum());
    }

    @Test
    public void 첫번째_기둥_bridge_리스트_만들기() {
        InputData inputData = new InputData(4, 3);
        Pillar p = new Pillar(inputData, null);

        System.out.println(p.getBridgesLocations());

        assertEquals(p.getBridgesDirectionLocation(LinkedType.RIGHT), p.getBridgesLocations());
        assertEquals(0, p.getBridgesDirectionLocation(LinkedType.LEFT).size());
    }

    @Test
    public void 두번째_기둥_bridge_리스트_만들기() {
        InputData inputData = new InputData(4, 10);
        Pillar p = new Pillar(inputData, null);
        Pillar p1 = new Pillar(inputData, p);

        List<Integer> p1LeftBridgesLocation = p1.getBridgesDirectionLocation(LinkedType.LEFT);
        List<Integer> p1RightBridgesLocation = p1.getBridgesDirectionLocation(LinkedType.RIGHT);
        List<Integer> pRightBridgesLocation = p.getBridgesDirectionLocation(LinkedType.RIGHT);

//        System.out.println("P RIGHT" + pRightBridgesLocation);
//        System.out.println("p1 LEFT" + p1LeftBridgesLocation);
//        System.out.println("p1 RIGHT" + p1RightBridgesLocation);

        assertEquals(p.getBridgesLocations(), p1LeftBridgesLocation);
        assertEquals(pRightBridgesLocation, p1LeftBridgesLocation);
        assertEquals(false, p1RightBridgesLocation.contains(p1LeftBridgesLocation));
    }

    @Test
    public void 마지막_기둥_bridge_리스트_만들기() {
        InputData inputData = new InputData(4, 10);
        Pillar p = new Pillar(inputData, null);
        Pillar p1 = new Pillar(inputData, p);
        Pillar p2 = new Pillar(inputData, p1);
        Pillar p3 = new Pillar(inputData, p2);

//        System.out.println("P RIGHT" + p.getBridgesDirectionLocation(LinkedType.RIGHT));
//        System.out.println("p1 LEFT" + p1.getBridgesDirectionLocation(LinkedType.LEFT));
//        System.out.println("p1 RIGHT" + p1.getBridgesDirectionLocation(LinkedType.RIGHT));
//        System.out.println("p2 LEFT" + p2.getBridgesDirectionLocation(LinkedType.LEFT));
//        System.out.println("p2 RIGHT" + p2.getBridgesDirectionLocation(LinkedType.RIGHT));
//        System.out.println("p3 LEFT" + p3.getBridgesDirectionLocation(LinkedType.LEFT));

        assertEquals(p3.getBridgesLocations(), p3.getBridgesDirectionLocation(LinkedType.LEFT));
        assertEquals(0, p3.getBridgesDirectionLocation(LinkedType.RIGHT).size());
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

    @Test
    public void 오른쪽_기둥_연결_bridge_생성하기() {
    }

    @Test
    public void 왼쪽_기둥_연결_bridge_생성하기() {
    }


}