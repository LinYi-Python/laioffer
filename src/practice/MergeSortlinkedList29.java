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
public class MergeSortlinkedList29 {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMid(head);
        ListNode middleNext = middle.next;
        middle.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(middleNext);

        return merge(left, right);

    }

    private ListNode findMid(ListNode head){
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right){
        // if(left == null){
        //   return right;
        // }
        // if(right == null){
        //   return left;
        // }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(left != null && right != null){
            if(left.value <= right.value){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        // while(left != null){
        //   curr.next = left;
        //   left = left.next;
        //   curr = curr.next;
        // }

        if(left != null){
            curr.next = left;
        }

        // while(right != null){
        //   curr.next = right;
        //   right = right.next;
        //   curr = curr.next;
        // }

        if(right != null){
            curr.next = right;
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
        MergeSortlinkedList29 test = new MergeSortlinkedList29();
        ListNode head = test.arrayToListNode(new int[]{1, 2, 3});
        ListNode result = test.mergeSort(head);
        System.out.println(test.ListNodeToString(result).toString());
    }

}
