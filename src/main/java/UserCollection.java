import java.util.ArrayList;
import java.util.List;

public class UserCollection {
    private List<User> users = new ArrayList<>();

    public UserCollection(List<String> users) {
        addUser(users);
    }

    private void addUser(List<String> users){
        for (int i = 0; i <users.size() ; i++) {
            User user = new User(users.get(i),i);
            this.users.add(user);
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public Integer getSize(){
        return users.size();
    }
}
