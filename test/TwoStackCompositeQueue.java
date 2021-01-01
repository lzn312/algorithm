import java.util.Stack;

public class TwoStackCompositeQueue<E> {
    private Stack<E> inStack;
    private Stack<E> outStack;

    public TwoStackCompositeQueue() {
        inStack = new Stack<E>();
        outStack = new Stack<E>();
    }

    public TwoStackCompositeQueue(Stack inStack, Stack outStack) {
        this.inStack = inStack;
        this.outStack = outStack;
    }

    public void push(E e) {
        inStack.push(e);
    }

    public void offer(E e) {
        outStack.push(e);
    }

    public E poll() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public E peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }





    public static void main(String[] args) {
        TwoStackCompositeQueue test = new TwoStackCompositeQueue();
    }
}
