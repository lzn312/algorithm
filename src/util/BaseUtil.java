package util;

import java.util.Random;

/**
 * 使用工具
 **/
public class BaseUtil {

    /**
     * 创建随机正整数数组
     *
     * @param maxValue 随机最大值
     * @param size     数组大小
     **/
    public static int[] randomIntArray(int maxValue, int size) {
        if (size <= 0 || size >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("数组大小不合理");
        }
        if (maxValue <= 0 || maxValue >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("最大值不合理");
        }

        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(maxValue);
        }

        return result;
    }


    /**
     * 创建有序正整数数组
     *
     * @param maxValue 随机最大值
     * @param size     数组大小
     **/
    public static int[] orderedIntArray(int maxValue, int size) {
        if (size <= 0 || size >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("数组大小不合理");
        }
        if (maxValue <= 0 || maxValue >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("最大值不合理");
        }
        Random random = new Random();
        int randomInt = random.nextInt(maxValue);
        int[] result = new int[size + 1];

        for (int i = 0; i <= size; i++) {
            randomInt = randomInt + random.nextInt(10);
            result[i] = randomInt;
        }

        return result;
    }
}
