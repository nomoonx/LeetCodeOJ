import java.util.List;

/**
 * Created by noMoon on 2015-01-02.
 */
public class RemoveNthNodeFromEndofList {
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
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = removeNthFromEnd(head, 5);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        boolean flag = true;
        int i = 0;
        for (; i < n + 1; i++) {
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            while (pointer2 != null) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            pointer1.next = pointer1.next.next;
            return head;
        } else {
            if (i == n) {
                return head.next;
            }
            return null;
        }
    }
}
