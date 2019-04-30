import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void 랜덤_불린_리스트_생성() {
        List<Boolean> b = Util.createRandomBooleans(3);
        assertEquals(3, b.size());
    }
}