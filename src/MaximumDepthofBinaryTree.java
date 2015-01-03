/**
 * Created by noMoon on 2014-11-14.
 */
public class MaximumDepthofBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
        root.right=new TreeNode(0);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(1);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(null==root) return 0;
        int max=0;
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left!=null){
            max=1+maxDepth(root.left);
        }
        if(root.right!=null){
            int temp=1+maxDepth(root.right);
            max=max>temp?max:temp;
        }
        return max;
    }
}
