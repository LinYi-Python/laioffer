package practice;
//https://app.laicode.io/app/problem/280?plan=3
import java.util.LinkedList;


public class SortWith2Stacks280 {

    public LinkedList<Integer> sort(LinkedList<Integer> s1) {
        if(s1 == null || s1.size() <= 1){
            return s1;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        //minValue 1
        //stack1 2 3 4 5 1.
        //stack2 1 5 4 3 2


        // minValue 2
        //stack1 2 3 4 5
        //stack2 1 || 5 4 3 2

        //int minValue = Integer.MAX_VALUE;


        //step1
        while(!s1.isEmpty()){
            int currMin = Integer.MAX_VALUE;
            int count = 0;
            while(!s1.isEmpty()){
                int curr = s1.pollFirst();
                if(curr < currMin){
                    currMin = curr;
                    count = 1;
                }else if(curr == currMin){
                    count++;
                }
                s2.offerFirst(curr);
            }
            while(!s2.isEmpty() && s2.peekFirst() >= currMin){
                int temp = s2.pollFirst();
                if(temp != currMin){
                    s1.offerFirst(temp);
                }

            }
            while(count-- > 0){
                s2.offerFirst(currMin);
            }

        }

        //step2
        while (!s2.isEmpty()){
            s1.offerFirst(s2.pollFirst());
        }
        return s1;
    }

    public static void main(String[] args) {
        SortWith2Stacks280 test = new SortWith2Stacks280();
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.addLast(4);
        s1.addLast(2);
        s1.addLast(1);
        s1.addLast(1);
        s1.addLast(3);
        s1.addLast(2);
        LinkedList<Integer> s2 = test.sort(s1);
        System.out.println(s2.toString()); // [1, 1, 2, 2 , 3 ,4]
    }
}


//备份
//
//public class Solution {
//    public void sort(LinkedList<Integer> s1) {
//        if(s1 == null || s1.size() <= 1){
//            return;
//        }
//        LinkedList<Integer> s2 = new LinkedList<Integer>();
//        // Write your solution here.
//        //minValue 1
//        //stack1 2 3 4 5 1.
//        //stack2 1 5 4 3 2
//
//
//        // minValue 2
//        //stack1 2 3 4 5
//        //stack2 1 || 5 4 3 2
//
//        //int minValue = Integer.MAX_VALUE;
//
//
//        //step1
//        while(!s1.isEmpty()){
//            int currMin = Integer.MAX_VALUE;
//            int count = 0;
//            while(!s1.isEmpty()){
//                int curr = s1.pollLast();
//                if(curr < currMin){
//                    currMin = curr;
//                    count = 1;
//                }else if(curr == currMin){
//                    count++;
//                }
//                s2.offerLast(curr);
//            }
//            while(!s2.isEmpty() && s2.peekLast() >= currMin){
//                int temp = s2.pollLast();
//                if(temp != currMin){
//                    s1.offerLast(temp);
//                }
//
//            }
//            while(count-- > 0){
//                s2.offerFirst(currMin);
//            }
//
//        }
//
//        //step2
//        while (!s2.isEmpty()){
//            s1.offerFirst(s2.pollFirst());
//        }
//
//    }
//}
