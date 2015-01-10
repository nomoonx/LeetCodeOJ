import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-08.
 */
public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        List<List<Integer>> result=levelOrder(root);
        for(List<Integer> array:result){
            for(int a:array){
                System.out.print(a);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(null==root) return result;
        List<TreeNode> current = new ArrayList<TreeNode>();
        List<TreeNode> temp = new ArrayList<TreeNode>();
        current.add(root);
        while (!current.isEmpty()) {
            List<Integer> tempInteger=new ArrayList<Integer>();
            for (TreeNode node : current) {
                tempInteger.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            result.add(tempInteger);
            current.clear();
            current.addAll(temp);
            temp.clear();
        }
        return result;
    }
}
