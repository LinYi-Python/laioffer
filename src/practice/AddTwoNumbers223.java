package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class AddTwoNumbers223 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Write your solution here
        // when l1 != null and l2 !=null. add their l1.value + l2.vale
        //during let carry = sum - 10;
        //sum = l1.val + l2.val + carry


        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.value + l2.value + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum - 10;
            }else{
                carry = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            curr.next = l1;
            curr = curr.next;
        }

        while(l2 != null){
            curr.next = l2;
            curr = curr.next;
        }

        return dummyHead.next;

    }


    private ListNode arrayToListNode(int[] array){
        ListNode head = new ListNode(array[0]);
        ListNode curr =head;
        for (int i = 1; i < array.length; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return head;
    }

    private List<Integer> ListNodeToString(ListNode head){
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
        AddTwoNumbers223 test = new AddTwoNumbers223();
        ListNode l1 = test.arrayToListNode(new int[]{2, 4, 3});
        ListNode l2 = test.arrayToListNode(new int[]{5, 6, 4});
        ListNode result = test.addTwoNumbers(l1, l2);
        System.out.println(test.ListNodeToString(result).toString());
    }
}





//simple ways

//    ListNode dummyHead = new ListNode(0);
//    ListNode cur = dummyHead;
//    int val = 0;
//    while(l1 != null || l2 != null || val != 0){
//            if(l1 != null){
//            val += l1.value;
//            l1 = l1.next;
//            }
//            if(l2 != null){
//            val += l2.value;
//            l2 = l2.next;
//            }
//
//            cur.next = new ListNode(val % 10);
//            val = val / 10;
//            cur = cur.next;
//            }
//            return dummyHead.next;
