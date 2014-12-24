/**
 * Created by noMoon on 2014-12-24.
 */
public class SameTree {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }

    public static void main(String[] args){
        System.out.println(111);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(null==p&&null==q) return true;
        if((null==p&&null!=q)||(null==q&&null!=p)) return false;
        if(compareNode(p,q)){
            if(null!=p.left&&null==p.right){
                return isSameTree(p.left,q.left);
            }else if (null!=p.right&&null==p.left){
                return isSameTree(p.right,q.right);
            }else if (null!=p.left&&null!=p.right){
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    public static boolean compareNode(TreeNode p,TreeNode q){
        if(p.val!=q.val) return false;
        if((null!=p.left&&null==q.left) || (null==p.left&&null!=q.left)) return false;
        if((null!=p.right&&null==q.right) || (null==p.right&&null!=q.right)) return false;
        return true;
    }
}
