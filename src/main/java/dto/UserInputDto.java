package dto;

import domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputDto {
    private static final String DELIMITER = ",";

    List<String> names;
    int height;

    public UserInputDto(String names, int height) {

        this.names = Arrays.asList(names.split(DELIMITER));
        this.height = height;
        validateInput();
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getHeight() {
        return height;
    }

    private void validateInput() {
        int people = names.size();
        if (people > height) {
            throw new IllegalArgumentException("잘못된 높이 입력.");
        }
    }

    public List<User> toEntities() {
        return this.names.stream()
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }
}
