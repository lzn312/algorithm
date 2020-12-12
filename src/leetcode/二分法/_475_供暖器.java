package leetcode.二分法;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 *
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 **/
public class _475_供暖器 {

    /**
     * 这题一开始我真的没什么思路，为什么能用二分法，
     * 真的就是懂了的人都懂，没懂的人啥都不懂。
     * 这题，我们只需要找到离房屋最近的供暖器，然后计算该房屋到最近供暖器的距离是多少就行。
     * 然后从上述所有房屋到供暖器的距离中选取最大的距离，就是最小的路径距离，
     * 但是要注意有坑，题中并没有说明房屋和供暖器谁是排序的
     **/
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int res = 0;
            for (int house : houses) {
                // 找知道最近距离的供暖器
                int gnqIndex = minRadiusGnq(house, heaters);
                // 我们不确定是否找到了供暖器的位置，所以选取它前一个点的位置和当前位置，选取距离最小的即可。 但是我们得判断下条件，如果为0，则不用算dist1了
                int dist1 = gnqIndex == 0 ? Integer.MAX_VALUE : Math.abs(house - heaters[gnqIndex - 1]);
                int dist2 = gnqIndex == heaters.length ? Integer.MAX_VALUE : Math.abs(house - heaters[gnqIndex]);
                res = Math.max(res, Math.min(dist1, dist2));
            }

            return res;

        }

        public int minRadiusGnq(int house,int[] heaters) {
            int low = 0, height = heaters.length;

            while (low < height) {
                int mid = low + ((height - low) >> 1);

                // 如果房屋值大于供暖器，则跳过他
                if (house > heaters[mid]) {
                    low = mid + 1;
                }else {
                    height = mid;
                }

            }
            return low;
        }

    public static void main(String[] args) {
        _475_供暖器 test = new _475_供暖器();
        System.out.println(test.findRadius(new int[]{1,5}, new int[]{2}));
    }
}
