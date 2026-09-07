import java.util.Stack;

public class maxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            maxStack.push(Math.max(x, maxStack.peek()));
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();

        Stack<Integer> temp = new Stack<>();

        while (stack.peek() != max) {
            temp.push(pop());
        }

        pop();

        while (!temp.isEmpty()) {
            push(temp.pop());
        }

        return max;
    }
}

