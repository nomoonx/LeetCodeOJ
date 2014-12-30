/**
 * Created by noMoon on 2014-12-29.
 */
public class LinkedListCycleII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        ListNode hoho=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        hoho.next=node1;
        node1.next=node2;
        node2.next=hoho;
        System.out.println(detectCycle(hoho).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(null==head) return null;
        ListNode pointerOne=head.next;
        if(null==pointerOne) return null;
        ListNode pointerTwo=head.next.next;
        while (pointerOne!=null&&pointerTwo!=null&&pointerOne!=pointerTwo){
            pointerOne=pointerOne.next;
            if(null==pointerTwo.next) break;
            pointerTwo=pointerTwo.next.next;
        }
        if(null==pointerOne||null==pointerTwo){
            return null;
        }
        if(pointerOne==pointerTwo){
            pointerTwo=head;
            while(pointerOne!=pointerTwo){
                pointerOne=pointerOne.next;
                pointerTwo=pointerTwo.next;
            }
            return pointerOne;
        }
        return null;
    }
}
