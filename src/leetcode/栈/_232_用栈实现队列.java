package leetcode.栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 **/
public class _232_用栈实现队列 {

    // 使用双栈来完成
    // pop/push操作都一样
    //出队先出outStack元素
    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
           if (outStack.isEmpty()){
               while (!inStack.isEmpty()){
                   outStack.push(inStack.pop());
               }
           }
           return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        _232_用栈实现队列 test = new _232_用栈实现队列();
        MyQueue myQueue = test.new MyQueue();
        myQueue.push(11);
        myQueue.push(22);
        myQueue.push(33);
        myQueue.push(44);
        while (!myQueue.empty()){
            System.out.println(myQueue.pop());
        }
    }
}
