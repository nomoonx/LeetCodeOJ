/**
 * Created by noMoon on 2015-01-22.
 */
public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = partition(head, 6);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode pointer = head;
        ListNode smallHead = null;
        ListNode smallTail = null;
        ListNode bigHead = null;
        ListNode bigtail = null;
        while (pointer != null) {
            if (pointer.val < x) {
                if (smallHead == null) {
                    smallHead = pointer;
                    smallTail = pointer;
                } else {
                    smallTail.next = pointer;
                    smallTail = pointer;
                }
            } else {
                if (bigHead == null) {
                    bigHead = pointer;
                    bigtail = pointer;
                } else {
                    bigtail.next = pointer;
                    bigtail = pointer;
                }
            }
            pointer = pointer.next;
        }
        if (null != smallHead) {

                if (null != bigHead) {
                    smallTail.next = bigHead;
                    bigtail.next = null;
                } else {
                    smallTail.next = null;
                }

            return smallHead;
        }
        else{
            bigtail.next = null;
            return bigHead;
        }
    }

}
