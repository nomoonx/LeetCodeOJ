import java.util.ArrayList;
import java.util.List;

/**
 * Created by noMoon on 2015-08-30.
 */
public class BinaryTreePaths {

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        root.right.right.right=new TreeNode(4);

        List<String> res=binaryTreePaths(root);
        for(String str:res){
            System.out.println(str);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<String>();
        List<TreeNode> nodes=new ArrayList<TreeNode>();
        List<String> paths=new ArrayList<String>();
        if(root==null) return result;
        nodes.add(root);
        paths.add(String.valueOf(root.val));
        while(nodes.size()>0){
            TreeNode node=nodes.get(0);
            String path=paths.get(0);
            if(node.left!=null){
                nodes.add(node.left);
                paths.add(path+"->"+String.valueOf(node.left.val));
            }
            if(node.right!=null){
                nodes.add(node.right);
                paths.add(path+"->"+String.valueOf(node.right.val));
            }
            if(node.left==null&&node.right==null){
                result.add(path);
            }
            nodes.remove(0);
            paths.remove(0);
        }
        return result;
    }
}
