import java.util.ArrayList;
import java.util.List;

public class UAP {
    private List<User> users = new ArrayList<>();
    private List<Prize> prizes = new ArrayList<>();

    public UAP(List<String> users, List<String> prizes) {
        validateSize(users,prizes);
        addUser(users);
        addPrize(prizes);
    }

    private void validateSize(List<String> users, List<String> prizes) {
        if(users.size() != prizes.size()){
            throw new IllegalArgumentException();
        }
    }

    private void addUser(List<String> users){
        for (int i = 0; i <users.size() ; i++) {
            User user = new User(users.get(i),i);
            this.users.add(user);
        }
    }

    private void addPrize(List<String> prizes){
        for (int i = 0; i <prizes.size() ; i++) {
            Prize prize = new Prize(prizes.get(i),i+1);
            this.prizes.add(prize);
        }
    }

    public int getPlayerSize() {
        return users.size();
    }
}
