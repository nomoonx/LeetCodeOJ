import java.util.*;

/**
 * Created by noMoon on 2015-01-14.
 */
public class MergekSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        ListNode list2 = new ListNode(10);
        ListNode list3 = new ListNode(3);
        list3.next = new ListNode(4);
        List<ListNode> lists = new ArrayList<ListNode>(Arrays.asList(list1, list2, list3));
        ListNode result = mergeKLists(lists);
        lists.add(null);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
        List<ListNode> lists2 = new ArrayList<ListNode>();
        lists2.add(null);
        lists2.add(new ListNode(1));
        result = mergeKLists(lists2);
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (null == lists || lists.isEmpty()) return null;
        Comparator comparator=new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };
        ListNode head = null;
        ListNode current = null;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) == null) {
                lists.remove(lists.get(i));
                if (lists.isEmpty()) return null;
                i--;
            }
        }
        Collections.sort(lists, comparator );
        ListNode min = lists.get(0);
        head = min;
        current = min;
        lists.remove(min);
        if (min.next != null) {
            int index=binarySearch(lists,min.next);
            lists.add(index,min.next);
        }
        while (!lists.isEmpty()) {
            min = lists.get(0);
            current.next = min;
            current = min;
            lists.remove(min);
            if (min.next != null) {
                int index=binarySearch(lists,min.next);
                lists.add(index,min.next);
            }
        }
        return head;
    }

    public static int binarySearch(List<ListNode> lists, ListNode node){
        if(lists.size()==0) return 0;
        if(lists.get(0).val>node.val) return 0;
        if(lists.get(lists.size()-1).val<node.val) return lists.size();
        int l=0;int u=lists.size();
        while(l<=u){
            int m=(l+u)/2;
            if(lists.get(m).val==node.val){
                return m;
            }
            else if(lists.get(m).val<node.val){
                l=m+1;
            }else if(lists.get(m).val>node.val){
                u=m-1;
            }
        }
        return l;
    }
}
