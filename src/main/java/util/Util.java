package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Util {
//    public
    public static List<Boolean> createRandomBooleans(Integer heights){
        Random random = new Random();
        List<Boolean> booleans = Arrays.asList(new Boolean[heights]);
        return booleans.stream()
                .map(bool -> random.nextBoolean())
                .collect(Collectors.toList());
    }
}
