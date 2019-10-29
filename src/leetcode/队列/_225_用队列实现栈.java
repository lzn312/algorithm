package leetcode.队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 **/
public class _225_用队列实现栈 {
    // 思路双队列一直交换存储 使得输入队列一直为空 输出队列直接弹出即可


    class MyStack {
        private Queue<Integer> inQueue;
        private Queue<Integer> outQueue;
        /** Initialize your data structure here. */
        public MyStack() {
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
           // 先在inQueue添加元素
            inQueue.offer(x);
            // 如果outQueue有元素在写回来
            while (!outQueue.isEmpty()){
                inQueue.offer(outQueue.poll());
            }
            // 交换in和out最终结果集
            Queue<Integer> temp = inQueue;
            inQueue = outQueue;
            outQueue = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
           return  outQueue.poll();
        }



        /** Get the top element. */
        public int top() {
            return outQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return outQueue.isEmpty();
        }
    }


    class MyStack1 {
        private Queue<Integer> inQueue;
        private Queue<Integer> outQueue;
        // 为了在调用top准备值
        private int top;
        /** Initialize your data structure here. */
        public MyStack1() {
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            // 先在inQueue添加元素
            inQueue.offer(x);
            top = x;

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
           while (inQueue.size() > 1){
               Integer poll = inQueue.poll();
               outQueue.offer(poll);
           }
            top = inQueue.poll();
            Queue<Integer> temp = outQueue;
            outQueue = inQueue;
            inQueue = temp;
            return top;
        }



        /** Get the top element. */
        public int top() {
            return  inQueue.peek();

        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return inQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        _225_用队列实现栈 test = new _225_用队列实现栈();
        MyStack1 myStack = test.new  MyStack1();
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        System.out.println(myStack.top);
//        System.out.println(myStack.empty());

    }
}
