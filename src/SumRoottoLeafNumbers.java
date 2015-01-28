import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-26.
 */
public class SumRoottoLeafNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (null == root) return 0;
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        int sum=0;
        while (!nodeList.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<TreeNode>();
            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    node.left.val =Integer.valueOf(String.valueOf(node.val)+String.valueOf(node.left.val));
                    tempList.add(node.left);
                }
                if (node.right != null) {
                    node.right.val =Integer.valueOf(String.valueOf(node.val)+String.valueOf(node.right.val));
                    tempList.add(node.right);
                }
                if (node.left == null && node.right == null) {
                    sum+=node.val;
                }
            }
            nodeList.clear();
            nodeList.addAll(tempList);
        }
        return sum;
    }
}
