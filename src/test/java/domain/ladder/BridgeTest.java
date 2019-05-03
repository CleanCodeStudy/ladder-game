package domain.ladder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BridgeTest {

    @Test
    public void 오른쪽_기둥_연결_bridge_생성하기() {
        Bridge bridge = new Bridge(1, LinkedType.RIGHT);
        assertEquals(LinkedType.RIGHT, bridge.getLinkPillarDirection());
    }

    @Test
    public void 왼쪽_기둥_연결_bridge_생성하기() {
        Bridge bridge = new Bridge(1, LinkedType.LEFT);
        assertEquals(LinkedType.LEFT, bridge.getLinkPillarDirection());
    }


}