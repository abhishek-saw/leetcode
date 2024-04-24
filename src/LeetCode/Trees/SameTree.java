package Trees;

public class SameTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRR = new TreeNode(6);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        System.out.println(isSameTree(root,rL));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        else if(p!=null && q==null){
            return false;
        }
        else if(p==null && q!=null){
            return false;
        }
        else if(p.val==q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        else {
            return false;
        }
    }
}
