package leetcode.top100.simple;

import java.util.*;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * https://leetcode-cn.com/problems/min-stack
 **/
public class _155_最小栈 {
    /**
     * 这一肯定要使用辅助空间来完成所以空间复杂度肯定为O(n)
     *  1是自己想的，很不完善效率也不高
     **/
    private static class MinStack1 {
        Stack<Integer> stack;
        ArrayList<Integer> minArrayList ;
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            stack = new Stack<>();
            minArrayList = new ArrayList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (x <= minValue){
                // 添加元素,且元素index就是size -1;
                minArrayList.add(x);
                minIndex = minArrayList.size() - 1;
                minValue = x;
            }

        }

        public void pop() {
            Integer pop = stack.pop();
            //删除最小值的时候进行一次排序
            if (pop == minValue) {
                minArrayList.remove(minIndex);
                if (minArrayList.size() >0){
                    Collections.sort(minArrayList);
                    minValue = minArrayList.get(0);
                    minIndex = 0;
                }else {
                    if (stack.size() == 1){
                        minArrayList.add(stack.peek());
                        minValue = stack.peek();
                        minIndex = 0;
                    }else {
                        minValue = Integer.MAX_VALUE;
                    }
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minValue;
        }
    }
    /**
     * 我们也可以使用辅助栈来完成
     * 当元素发生变动的时候进行变动辅助栈
     **/
    private static class MinStack{
        // 数据栈
        private Stack<Integer> data;
        // 辅助栈
        private Stack<Integer> helper;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        // 思路 2：辅助栈和数据栈不同步
        // 关键 1：辅助栈的元素空的时候，必须放入新进来的数
        // 关键 2：新来的数小于或者等于辅助栈栈顶元素的时候，才放入（特别注意这里等于要考虑进去）
        // 关键 3：出栈的时候，辅助栈的栈顶元素等于数据栈的栈顶元素，才出栈，即"出栈保持同步"就可以了

        public void push(int x) {
            // 辅助栈在必要的时候才增加
            data.add(x);
            // 关键 1 和 关键 2
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            }
        }

        public void pop() {
            // 关键 3：data 一定得 pop()
            if (!data.isEmpty()) {
                // 注意：声明成 int 类型，这里完成了自动拆箱，从 Integer 转成了 int，因此下面的比较可以使用 "==" 运算符
                // 参考资料：https://www.cnblogs.com/GuoYaxiang/p/6931264.html
                // 如果把 top 变量声明成 Integer 类型，下面的比较就得使用 equals 方法
                int top = data.pop();
                if(top == helper.peek()){
                    helper.pop();
                }
            }
        }

        public int top() {
            if(!data.isEmpty()){
                return data.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {
            if(!helper.isEmpty()){
                return helper.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

    public static void main(String[] args) {
        //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        MinStack minStack = new MinStack();
       minStack.push(2147483646);
       minStack.push(2147483646);
       minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();;
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
//        [2147483647,2147483646,2147483646,2147483647,2147483647,-2147483648,-2147483648,2147483647]
    }
}
