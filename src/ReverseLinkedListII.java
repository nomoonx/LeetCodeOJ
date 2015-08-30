/**
 * Created by noMoon on 2015-08-30.
 */
public class ReverseLinkedListII {

    public static class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }

    }
    public static void main(String[] args){
        ListNode head=new ListNode(5);
        head.next=new ListNode(4);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(2);
//        head.next.next.next.next=new ListNode(1);
        ListNode result=reverseBetween(head,1,2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
        ListNode current=head;
        ListNode previous=null;
        for(int i=1;i<m;i++){
            previous=current;
            current=current.next;
        }
        ListNode tempCurrent=current;
        ListNode tempPrevious=null;
        for(int i=m;i<=n;i++){
            ListNode temp=tempCurrent.next;
            tempCurrent.next=tempPrevious;
            tempPrevious=tempCurrent;
            tempCurrent=temp;
        }
        if(previous!=null){
            previous.next=tempPrevious;
        }else{
            head=tempPrevious;
        }
        current.next=tempCurrent;
        return head;
    }
}
