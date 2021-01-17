package review.一月.stack;

import java.util.Stack;

public class _155_最小栈 {


    // 使用两个栈来完成
 public static  class MinStack {

     Stack<Integer> minStack;
     Stack<Integer> supStack;
     /**
      * initialize your data structure here.
      */
     public MinStack() {
         minStack = new Stack<>();
         supStack = new Stack<>();
     }

     public void push(int x) {
         minStack.push(x);

         if (supStack.isEmpty() || supStack.peek() >= x){
             supStack.push(x);
         }
     }

     public void pop() {
         if (!minStack.isEmpty()) {
             Integer pop = minStack.pop();
             if (supStack.peek().equals(pop)){
                 supStack.pop();
             }
         }
     }

     public int top() {
         return minStack.peek();
     }

     public int getMin() {
         return supStack.peek();

     }

 }
}
