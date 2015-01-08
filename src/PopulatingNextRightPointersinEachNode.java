import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-03.
 */
public class PopulatingNextRightPointersinEachNode {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.right.left = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(6);
        connect(root);
        TreeLinkNode node = root.left.left;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void connect(TreeLinkNode root) {
        if(null==root) return;
        List<TreeLinkNode> current = new ArrayList<TreeLinkNode>();
        List<TreeLinkNode> temp = new ArrayList<TreeLinkNode>();
        current.add(root);
        while (!current.isEmpty()) {
            for (TreeLinkNode node : current) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            for (int i = 0; i < temp.size() - 1; i++) {
                temp.get(i).next = temp.get(i + 1);
            }
            current.clear();
            current.addAll(temp);
            temp.clear();
        }
    }
}
