package Trees;

public class maxDepthBT {
    //      Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRR = new TreeNode(6);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
