package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {
    @Test
    public void 사용자_이름_얻기() {
        //given
        User user = new User("test",1);
        //when
        //then
        assertThat(user.getName()).isEqualTo("test");
    }

    @Test
    public void 사용자_시작_번호_얻기() {
        //given
        User user = new User("test",2);
        //when
        //then
        assertThat(user.getStartColumn()).isEqualTo(2);
    }
}