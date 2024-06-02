package Trees;

public class LeetCode98_IsValidBST {
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
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        return isBSTHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private static boolean isBSTHelper(TreeNode root, long minValue, long maxValue) {
        if(root==null){
            return true;
        }
        if(root.val<=minValue){
            return false;
        }
        if(root.val>=maxValue){
            return false;
        }
        return isBSTHelper(root.left,minValue,root.val) && isBSTHelper(root.right,root.val,maxValue);
    }
}
