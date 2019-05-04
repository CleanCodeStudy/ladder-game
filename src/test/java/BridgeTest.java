import com.cys.ladder.domain.ladder.Bridge;
import com.cys.ladder.domain.ladder.Point;
import org.junit.Test;

import java.util.Arrays;

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
        assertEquals(firstBridge.nextPoint(currentColumn),rightPoint);
        assertEquals(firstBridge.nextPoint(1),leftPoint);
    }

    @Test
    public void 첫번쨰_브릿지_연결안된거() {
        //given
        //when
        //then
    }
}