package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class MergeTwoSortedLinkedLists40 {
    public ListNode merge(ListNode one, ListNode two) {
        // Write your solution here

        if(one == null){
            return two;
        }
        if(two == null){
            return one;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode oneIndex = one;
        ListNode twoIndex = two;
        ListNode curr = dummyHead;
        while(oneIndex != null && twoIndex != null){
            if(oneIndex.value >= twoIndex.value){
                curr.next = twoIndex;
                twoIndex = twoIndex.next;
                curr = curr.next;
            }else{
                curr.next = oneIndex;
                oneIndex = oneIndex.next;
                curr = curr.next;
            }
        }
        if(oneIndex != null){
            curr.next = oneIndex;
        }else{
            curr.next = twoIndex;
        }

        return dummyHead.next;
    }

    private ListNode arrayToListNode(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode curr =head;
        for (int i = 1; i < array.length - 1; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return head;
    }

    private List<Integer> ListNodeToString(ListNode head){
//
//        if(head == null){
//            return null;
//        }
//        StringBuilder s = new StringBuilder("");
//        while(head != null){
//            StringBuilder temp = new StringBuilder(Integer.toString(head.value));
//            s.append(temp);
//        }
//        return s.toString();
        if(head == null){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        while(head != null){
            result.add(head.value);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedLists40 test = new MergeTwoSortedLinkedLists40();
        ListNode one = test.arrayToListNode(new int[]{1});
        ListNode two = test.arrayToListNode(new int[]{2, 3, 4});
        ListNode result = test.merge(one, two);
        List<Integer> ListResult = test.ListNodeToString(result);
        System.out.println(ListResult.toString());

    }
}
