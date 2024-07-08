package com.bearya.robot.base.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CodeUtils {
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static long random(long min, long max) {
        return Math.round(Math.random() * (max - min) + min);
    }

    @SafeVarargs
    public static <T> T oneOf(T... array) {
        if (array == null || array.length <= 0) {
            throw new IllegalArgumentException("array not be empty");
        }
        return array[new Random().nextInt(array.length)];
    }

    public static boolean containEmotion(String emotionName) {
        List<String> emotions = Arrays.asList(
                "zc", "dx", "hg", "hx", "gl", "hs", "aj", "axy", "sj"
                , "sq", "smq", "sh", "zj", "y", "ja", "my", "zm", "bz");
        return emotions.contains(emotionName);
    }

}
