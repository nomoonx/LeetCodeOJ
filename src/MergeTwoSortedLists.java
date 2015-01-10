/**
 * Created by noMoon on 2015-01-08.
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        ListNode l1=new ListNode(-9);
        ListNode l2=new ListNode(5);
        l1.next=new ListNode(3);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode result=mergeTwoLists(l1,l2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null==l1&&null==l2) return null;
        if(null==l1) return l2;
        if(null==l2) return l1;
        ListNode head1=l1;
        ListNode head2=l2;
        ListNode head=null;
        if(l1.val<l2.val){
            head=l1;
            head1=head1.next;
        }else{
            head=l2;
            head2=head2.next;
        }
        ListNode list=head;
        while(head1!=null||head2!=null){
            if(null==head1){
                list.next=head2;
                break;
            }else if(null==head2){
                list.next=head1;
                break;
            }
            if(head1.val>head2.val){
                list.next=head2;
                list=list.next;
                head2=head2.next;
            }else{
                list.next=head1;
                list=list.next;
                head1=head1.next;
            }
        }
        return head;
    }
}
