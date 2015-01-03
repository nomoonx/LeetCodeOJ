import java.util.List;

/**
 * Created by noMoon on 2014-12-31.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        boolean flag1 = null == l1;
        boolean flag2 = null == l2;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (flag1) {
                result.val = (l2.val+carry)%10;
                carry=(l2.val+carry)/10;
                l2 = l2.next;
            } else if (flag2) {
                result.val = (l1.val+carry)%10;
                carry=(l1.val+carry)/10;
                l1 = l1.next;
            } else {
                result.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            flag1 = null == l1;
            flag2 = null == l2;
            if (!(flag1 && flag2)) {
                result.next = new ListNode(0);
                result = result.next;
            }else if(carry>0){
                result.next = new ListNode(carry);
            }

        }
        return temp;
    }
}
