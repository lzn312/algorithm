package leetcode.everyday;

import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *  
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 **/
public class _1046_最后一块石头的重量 {




    /**
     *
     **/
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0){
            return 0;
        }
        if (stones.length == 1){
            return stones[0];
        }
        // 加入一个大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (first, second) ->
                        (first > second) ? -1 :
                              (first.equals(second)) ? 0 :
                                      1 );

        //

        for (int stone : stones) {
            priorityQueue.offer(stone);
        }


        while ( !priorityQueue.isEmpty()){
            Integer val1 = priorityQueue.poll();
            Integer val2 = priorityQueue.poll();
            if ( val2 == null ){
                return val1;
            }
            if (val1 - val2 > 0){
                priorityQueue.offer(val1 - val2);
            }
        }


        return 0;

    }

    public static void main(String[] args) {
        _1046_最后一块石头的重量 test = new _1046_最后一块石头的重量();
        System.out.println(test.lastStoneWeight(new int[]{2,7,4,1,8,1}));

    }
}
