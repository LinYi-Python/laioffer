package practice;

class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
      this.value = value;
      next = null;
    }
 }

public class ReverseLinkedListRecurisve653 {
    public ListNode reverse(ListNode head) {
        // Write your solution here

        // 1 -> 2 -> 3 -> 4

        // 1 -> 2 -> 3 <- 4
        if(head == null || head.next == null){
            return head;
        }

//        if(head.next == null){
//            ListNode want = head;
//            return head;
//        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
//        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedListRecurisve653 test = new ReverseLinkedListRecurisve653();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode result = test.reverse(node1);

    }
}
