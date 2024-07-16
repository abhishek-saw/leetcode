package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode112_HasPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rL = new TreeNode(4);
        TreeNode rR = new TreeNode(8);
        TreeNode rLL = new TreeNode(11);
        TreeNode rRL = new TreeNode(13);
        TreeNode rRR = new TreeNode(4);
        TreeNode rLLL = new TreeNode(7);
        TreeNode rLLR = new TreeNode(2);
        TreeNode rRRR = new TreeNode(1);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rR.left = rRL;
        rR.right = rRR;
        rLL.left = rLLL;
        rLL.right = rLLR;
        rRR.right = rRRR;
        printBT(root);
        System.out.println();
        TreeNode root1 = new TreeNode(1);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(3);
        root1.left = rL1;
        root1.right = rR1;
        printBT(root1);
        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum(root1, 3));
        System.out.println(hasPathSum(null, 0));
        System.out.println(hasPathSumBetter(root, 22));
        System.out.println(hasPathSumBetter(root1, 3));
        System.out.println(hasPathSumBetter(null, 0));

    }

    private static boolean hasPathSumBetter(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean left = hasPathSumBetter(root.left, targetSum-root.val);
        boolean right = hasPathSumBetter(root.right, targetSum-root.val);
        return left||right;
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return path(root, targetSum, 0);
    }

    private static boolean path(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == sum+root.val;
        }
        boolean left = path(root.left, targetSum, sum+root.val);
        boolean right = path(root.right, targetSum, sum+root.val);
        return left||right;
    }
}