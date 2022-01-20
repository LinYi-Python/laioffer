package practice;


import java.util.ArrayDeque;
import java.util.Deque;

public class ThreeStackMin32 {
    private Deque<Integer> stack;
    private Deque<Integer> pos;
    private Deque<Integer> min;
    public ThreeStackMin32() {
        stack = new ArrayDeque<Integer>();
        pos = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
    }

    public int pop() {
        if (stack.isEmpty()){
            return -1;
        }

        boolean flag1 = (stack.peekFirst() == min.peekFirst());
        boolean flag2 = (stack.size() == pos.peekFirst());
        boolean flag3 = stack.peekFirst().equals(min.peekFirst());

        Integer s1 = stack.peekFirst();
        Integer s2 = stack.peekFirst();
        boolean flag4 = s1 == s2;

        if (stack.peekFirst() == min.peekFirst() && stack.size() == pos.peekFirst()){
            min.pollFirst();
            pos.pollFirst();
        }
        return stack.pollFirst();
    }

    public void push(int element) {
        stack.offerFirst(element);
        if (min.isEmpty() || element < min.peekFirst()){
            min.offerFirst(element);
            pos.offerFirst(stack.size());
        }

    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peekFirst();
    }

    public int min() {
        return min.isEmpty() ? -1 : min.peekFirst();
    }


    public static void main(String[] args) {
        ThreeStackMin32 test = new ThreeStackMin32();
        test.push(136);
        int result1 = test.min();
        System.out.println(result1);
        test.push(135);
        test.push(139);
        int result2 = test.top();
        System.out.println(result2);
        int result3 = test.min();
        System.out.println(result3);
        int result4 = test.pop();
        System.out.println(result4);
        int result5 = test.min();
        System.out.println(result5);
        int result6 = test.top();
        System.out.println(result6);
        int result7 = test.min();
        System.out.println(result7);
        int result8 = test.pop();
        System.out.println(result8);
        int result9 = test.min();
        System.out.println(result9);
    }
}
