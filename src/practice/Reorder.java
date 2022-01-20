package practice;

//class ListNode<E>{
//    E val;
//    ListNode<E> next;
//
//    ListNode(E val){
//        this.val=val;
//    }
//}

public class Reorder {
    public ListNode reorder(ListNode head){
        if(head == null) {
            return null;
        }
        if(head.next == null || head.next.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        //reverse second


        rightHead = reverse(rightHead);


        //merge
        ListNode result = merge(head, rightHead);
        return result;



    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        // 1 2 3 4 5 6
    }


    private ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
        return prev;
    }


    private ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(leftHead != null && rightHead != null ){
            curr.next = leftHead;
            leftHead = leftHead.next;
            curr.next.next = rightHead;
            rightHead = rightHead.next;
            curr = curr.next.next;
        }
        if(leftHead == null){
            curr.next = rightHead;
        }else{
            curr.next = leftHead;
        }
//        if(rightHead == null){
//            curr.next = leftHead;
//        } //这个是错误的
        return dummyHead.next;
    }
}
