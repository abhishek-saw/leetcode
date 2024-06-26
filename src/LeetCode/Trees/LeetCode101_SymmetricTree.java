package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(2);
        TreeNode rLL = new TreeNode(3);
        TreeNode rLR = new TreeNode(4);
        TreeNode rRL = new TreeNode(4);
        TreeNode rRR = new TreeNode(3);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println(isSymmetricBetter(root));
        System.out.println(isSymmetric(root));
        printBT(root);
    }

    private static boolean isSymmetricBetter(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    private static boolean isSymmetric(TreeNode root) {
        invertTree(root.left);
        return isSameTree(root.left,root.right);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        else if(p==null || q==null){
            return false;
        }
        else if(p.val==q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }

    private static void invertTree(TreeNode node) {
        if(node==null){
            return;
        }
        invertTree(node.left);
        invertTree(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}