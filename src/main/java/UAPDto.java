import java.util.Arrays;
import java.util.List;

public class UAPDto {
    private List<String> users;
    private List<String> prizes;

    public UAPDto(String users, String prizes) {
        this.users = Arrays.asList(users.split(","));
        this.prizes = Arrays.asList(users.split(","));
    }

    public UAP toEntity(){
        return new UAP(users,prizes);
    }
}
