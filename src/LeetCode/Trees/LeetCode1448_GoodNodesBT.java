package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1448_GoodNodesBT {
    static int count = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(4);
        TreeNode rLL = new TreeNode(3);
        TreeNode rRL = new TreeNode(1);
        TreeNode rRR = new TreeNode(5);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println();
        TreeNode root1 = new TreeNode(3);
        TreeNode rL1 = new TreeNode(3);
        TreeNode rLL1 = new TreeNode(4);
        TreeNode rLR1 = new TreeNode(2);
        root1.left = rL1;
        rL1.left = rLL1;
        rL1.right = rLR1;
        printBT(root1);
        System.out.println();
        System.out.println(goodNodes(root));
        System.out.println(goodNodes(root1));
    }

    private static int goodNodes(TreeNode root) {
        goodNodesHelper(root,Integer.MIN_VALUE);
        return count;
    }

    private static void goodNodesHelper(TreeNode root, int val) {
        if(root.val>=val){
            count++;
            val = root.val;
        }
        if(root.left!=null) {
            goodNodesHelper(root.left, val);
        }
        if(root.right!=null) {
            goodNodesHelper(root.right, val);
        }
    }
}
