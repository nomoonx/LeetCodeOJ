/**
 * Created by noMoon on 2015-01-20.
 */
public class SwapNodesinPairs {

    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                     val = x;
                     next = null;
                 }
         }

    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        ListNode result=swapPairs(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
        System.out.println();
        head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        result=swapPairs(head);
        while(result!=null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println();
        head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        result=swapPairs(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
        System.out.println();
        head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        result=swapPairs(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode c1=head;
        ListNode c2=head.next;
        ListNode next=c2.next;
        c2.next=c1;
        c1.next=next;
        head=c2;
        ListNode last=c1;
        while(next!=null){
            c1=next;
            c2=c1.next;
            if(c2==null) break;
            next=c2.next;
            c2.next=c1;
            c1.next=next;
            last.next=c2;
            last=c1;
        }
        return head;
    }
}
