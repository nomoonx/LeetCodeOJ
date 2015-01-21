/**
 * Created by noMoon on 2015-01-20.
 */
public class IntersectionofTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        ListNode headA=new ListNode(0);
        headA.next=new ListNode(1);
        ListNode headB=new ListNode(3);
        ListNode tail=new ListNode(33);

        System.out.println(getIntersectionNode(headA,headB)==null);
        headA.next.next=tail;
        headB.next=tail;
        System.out.println(getIntersectionNode(headA,headB).val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        ListNode tailA = null;
        while (pointerA != null) {
            if (pointerA.next == null) tailA = pointerA;
            pointerA = pointerA.next;
            lengthA++;
        }
        boolean flag = false;
        while (pointerB != null) {
            if (pointerB.equals(tailA)) flag = true;
            pointerB = pointerB.next;
            lengthB++;
        }
        if (flag) {
            pointerA=headA;
            pointerB=headB;
            if(lengthA>lengthB){
                for(int i=0;i<lengthA-lengthB;i++){
                    pointerA=pointerA.next;
                }
            }else if(lengthA<lengthB){
                for(int i=0;i<lengthB-lengthA;i++){
                    pointerB=pointerB.next;
                }
            }
            while(!pointerA.equals(pointerB)){
                pointerA=pointerA.next;
                pointerB=pointerB.next;
            }
            return pointerA;
        } else {
            return null;
        }
    }
}
