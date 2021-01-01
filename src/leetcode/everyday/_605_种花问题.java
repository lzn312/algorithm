package leetcode.everyday;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 **/
public class _605_种花问题 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0 || flowerbed.length < n) {
            return false;
        }
        if (flowerbed.length == 1){
            return (flowerbed[0] == 0 && n <= 1) || (flowerbed[0] == 1 && n == 0);
        }

        int count = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (count == 0) {
                break;
            }
            int prev = i - 1;
            int next = i + 1;
            if (i == 0) {
                if (flowerbed[next] == 0) {
                    flowerbed[i] = 1;
                    count--;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[prev] == 0) {
                    flowerbed[i] = 1;
                    count--;
                }
            } else {
                if (flowerbed[prev] == 0 && flowerbed[next] == 0) {
                    flowerbed[i] = 1;
                    count--;
                }
            }


        }


        return count <= 0;

    }


    public static void main(String[] args) {
        _605_种花问题 test = new _605_种花问题();
        System.out.println(test.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(test.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
    }
}
