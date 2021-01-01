package leetcode.数组;

import java.util.Stack;

/**
 * @author Leezer
 * @date 2020/12/21 8:15 下午
 **/
public class _84_柱状图中最大的矩形 {


    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0){
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }


        // 放入新的数组里面，为了两边边界简化处理
        int[] newHeights = new int[heights.length  + 2 ];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        System.arraycopy(heights,0,newHeights, 1, heights.length);
        heights = newHeights;
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        // 哨兵节点，取出非空判断
        stack.push(0);
        for (int i = 1; i < newHeights.length; i++) {

            // 如果当前柱小于历史单调递增栈
            while (heights[i] < heights[stack.peek()]){
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                res = Math.max( res, currHeight * currWidth);
            }
            stack.push(i);


        }

        return res;
    }
}
