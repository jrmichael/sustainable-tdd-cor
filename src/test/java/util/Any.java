package util;

import java.util.Random;

public class Any {

    public static int intValue() {
        return new Random().nextInt();
    }

    public static int integerBetween(int min, int max) {
        return min + new Random().nextInt(max - min);
    }

}
