
/**
 * Created by noMoon on 2015-01-20.
 */
public class RotateList {

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
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(4);
//        head.next.next.next.next=new ListNode(5);
        ListNode result=rotateRight(head,3);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int n) {
        if(head==null) return null;
        ListNode pointer=head;
        int length=0;
        for(int i=0;i<n;i++){
            length++;
            pointer=pointer.next;
            if(pointer==null) {
                return rotateRight(head,n%length);
            }
        }
        ListNode pointer2=head;
        while(pointer.next!=null){
            pointer2=pointer2.next;
            pointer=pointer.next;
        }
        pointer.next=head;
        head=pointer2.next;
        pointer2.next=null;
        return head;
    }
}
