package dto;

import domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputDto {
    private static final String DELIMITER = ",";

    List<String> names;

    public UserInputDto(String name) {
        this.names = Arrays.asList(name.split(DELIMITER));
    }

    public List<String> getNames() {
        return this.names;
    }

    public List<User> toEntities() {
        return this.names.stream()
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }
}
