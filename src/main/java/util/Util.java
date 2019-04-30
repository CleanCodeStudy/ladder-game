package util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
//    public
    public static final int MIN_HEIGHT_INDEX = 0;

    public static List<Integer> createRandomIntegers(Integer heights){
        List<Integer> randoms = IntStream.range(MIN_HEIGHT_INDEX, heights)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
        Collections.shuffle(randoms);

        return randoms.stream()
                .limit(new Random().nextInt(heights+1))
                .collect(Collectors.toList());
    }
}
