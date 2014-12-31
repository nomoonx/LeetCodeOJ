/**
 * Created by noMoon on 2014-12-30.
 */
public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        ListNode root=new ListNode(1);
        root.next=new ListNode(1);
        root.next.next=new ListNode(2);
        ListNode head=deleteDuplicates(root);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(null==head) return null;
        ListNode pointer=head;
        while(null!=pointer.next){
            if(pointer.next.val==pointer.val){
                pointer.next=pointer.next.next;
            }else{
                pointer=pointer.next;
            }
        }
        return head;
    }
}
