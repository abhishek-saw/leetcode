package Trees;

public class LeetCode965_UniValuedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(1);
        TreeNode rLL = new TreeNode(1);
        TreeNode rLR = new TreeNode(1);
        TreeNode rRR = new TreeNode(1);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        System.out.println(isUnivalTree(root));
    }

    private static boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        else {
            return isUnivalTreeHelper(root,root.val);
        }
    }

    private static boolean isUnivalTreeHelper(TreeNode root, int val) {
        if(root== null){
            return true;
        }
        if(root.val!=val){
            return false;
        }
        else {
            return isUnivalTreeHelper(root.left,val) &&  isUnivalTreeHelper(root.right,val) ;
        }

    }
}
