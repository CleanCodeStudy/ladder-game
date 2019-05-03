package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static data.InputData.DELIMETER;

public class Util {
    //    public
    public static final int MIN_HEIGHT_INDEX = 0;

    public static List<Integer> createRandomIntegers(Integer heights) {
        List<Integer> randoms = IntStream.range(MIN_HEIGHT_INDEX, heights)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
        Collections.shuffle(randoms);

        return randoms.stream()
                .limit(randInt(heights))
                .collect(Collectors.toList());
    }

    public static List<Integer> createRandomIntegersWithRestriction(Integer heights, List<Integer> restrictions) {
        List<Integer> randoms = createRandomIntegers(heights);
        return randoms.stream()
                .filter(i -> !restrictions.contains(i))
                .collect(Collectors.toList());
    }

    public static List<String> separateUserName(String participants) {
        String[] users = participants.split(DELIMETER);
        return Arrays.asList(users);
    }

    public static Integer randInt(int bound) {
        return (int) (Math.random() * bound + 1);
    }
}
