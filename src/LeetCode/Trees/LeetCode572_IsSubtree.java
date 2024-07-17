package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode572_IsSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rL = new TreeNode(4);
        TreeNode rR = new TreeNode(5);
        TreeNode rLL = new TreeNode(1);
        TreeNode rLR = new TreeNode(2);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        printBT(root);
        System.out.println();
        TreeNode subRoot = new TreeNode(4);
        TreeNode sL = new TreeNode(1);
        TreeNode sR = new TreeNode(2);
        subRoot.left = sL;
        subRoot.right = sR;
        printBT(subRoot);
        System.out.println(isSubtree(root,subRoot));

        TreeNode root1 = new TreeNode(3);
        TreeNode rL1 = new TreeNode(4);
        TreeNode rR1 = new TreeNode(5);
        TreeNode rLL1 = new TreeNode(1);
        TreeNode rLR1 = new TreeNode(2);
        TreeNode rLRL1 = new TreeNode(0);
        root1.left = rL1;
        root1.right = rR1;
        rL1.left = rLL1;
        rL1.right = rLR1;
        rLR1.left = rLRL1;
        printBT(root1);
        System.out.println();
        TreeNode subRoot1 = new TreeNode(4);
        TreeNode sL1 = new TreeNode(1);
        TreeNode sR1 = new TreeNode(2);
        subRoot1.left = sL1;
        subRoot1.right = sR1;
        printBT(subRoot1);
        System.out.println(isSubtree(root1,subRoot1));
    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if (root.val == subRoot.val && isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
    private static boolean isSame(TreeNode p, TreeNode q){
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}