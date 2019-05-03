public class User {
    private String name;
    private Integer location;

    public User(String name, Integer location) {
        validateName(name);
        this.name = name;
        this.location = location+1;
    }

    private void validateName(String name){
        if(name.length() >= 5){
            throw new IllegalArgumentException();
        }
    }

    public boolean isEqualToLocation(Integer location){
        return this.location == location;
    }

    public String getName() {
        return name;
    }


}
