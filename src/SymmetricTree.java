import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-01-20.
 */
public class SymmetricTree {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right=new TreeNode(3);
        node2.right=new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
    public static boolean isSymmetric(TreeNode root) {

        List<Integer> preResult=preorderTraversal(root);
        List<Integer> reversePreResult=reversePreorderTraversal(root);
        int length=preResult.size();
        for(int i=0;i<length;i++){
            if(preResult.get(i)!=reversePreResult.get(i)) return false;
        }
        List<Integer> inResult=inorderTraversal(root);
        List<Integer> reverseInResult=reverseInorderTraversal(root);
        for(int i=0;i<length;i++){
            if(inResult.get(i)!=reverseInResult.get(i)) return false;
        }
        return true;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == root) return result;
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public static List<Integer> reversePreorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == root) return result;
        result.add(root.val);
        result.addAll(reversePreorderTraversal(root.right));
        result.addAll(reversePreorderTraversal(root.left));
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == root) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public static List<Integer> reverseInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == root) return result;
        result.addAll(reverseInorderTraversal(root.right));
        result.add(root.val);
        result.addAll(reverseInorderTraversal(root.left));
        return result;
    }
}
