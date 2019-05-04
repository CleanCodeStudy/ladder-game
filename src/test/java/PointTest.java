import com.cys.ladder.domain.LinkedStatus;
import com.cys.ladder.domain.ladder.Point;
import org.junit.Test;

public class PointTest {

    @Test
    public void 오른쪽_연결된_포인트_생성하기() {
        assertEquals(Point.createRightLinkedPoint(1).getLinkedStatus(), LinkedStatus.RIGHT);
    }

    @Test
    public void 왼쪽_연결된_포인트_생성하기() {
        assertEquals(Point.createLeftLinkedPoint(2).getLinkedStatus(), LinkedStatus.LEFT);
    }

    @Test
    public void 연결안된_포인트_생성하기() {
        assertEquals(Point.createNotLinkedPoint(1).getLinkedStatus(), LinkedStatus.NONE);
    }
}