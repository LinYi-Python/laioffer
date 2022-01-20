package practice;

import java.util.LinkedList;


public class QueueByTwoStacks31 {

    private LinkedList<Integer> s1 = new LinkedList<>();
    private LinkedList<Integer> s2 = new LinkedList<>();

    public QueueByTwoStacks31() {
        // Write your solution here.


    }
    // stack FILO
    // queue FIFO
    // stack1 1 3 5 0 8
    // stack2 8 0 5 3 1
    // out: 1 3 5 0 8

    public Integer poll() {
        move();
        if(s2.isEmpty()){
            return null;
        }else{
            return s2.pollFirst();
        }

    }

    public void offer(int element) {
        s1.offerFirst(element);
    }

    public Integer peek() {
        move();
        if(s2.isEmpty()){
            return null;
        }else{
            return s2.peekFirst();
        }

    }

    public int size() {
        if(s1.size() == 0 && s2.size() == 0){
            return 0;
        }
        return s1.size() + s2.size();

    }

    public boolean isEmpty() {
        if(s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        return false;
    }

    private void move(){
        //move stack1 to stack2 one by one
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.offerFirst(s1.pollFirst());
            }
        }


    }
}
