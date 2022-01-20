package practice;


import java.util.Stack;

public class StackWithMin32 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public StackWithMin32() {
        // write your solution here

    }

    // 2 4 1 1 5 6
    // 2   1 1

    public int pop() {
        if(stack.isEmpty()){
            return -1;
        }
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }

        return stack.pop();
    }

    public void push(int element) {
        stack.push(element);
        if(minStack.isEmpty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();

    }

    public int min() {
        if(stack.isEmpty()){
            return -1;
        }
        return minStack.peek();

    }
}
