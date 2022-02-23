package test;


import java.util.ArrayList;
import java.util.List;


class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
  }

public class ArrayToListNode {
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
}
