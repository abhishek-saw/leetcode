package Trees;

public class LeetCode938_RangeSumBST {
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
        System.out.println(rangeSumBST(root,2,5));
    }

    private static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int sum =0;
        if(low<=root.val && high>=root.val){
            sum+=root.val;
        }
        int left = rangeSumBST(root.left,low,high);
        int right = rangeSumBST(root.right,low,high);
        return sum+left+right;
    }
}