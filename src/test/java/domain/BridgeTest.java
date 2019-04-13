package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BridgeTest {

    @Test
    public void Bridge_생성하기() {
        int bridgeLocation = 1;
        int leftPillar = 1;
        Bridge bridge = new Bridge(bridgeLocation,leftPillar);

        assertThat(bridge.getLocation()).isEqualTo(1);
    }
}