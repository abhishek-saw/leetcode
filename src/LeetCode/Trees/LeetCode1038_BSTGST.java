package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1038_BSTGST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(6);
        TreeNode rLL = new TreeNode(0);
        TreeNode rLR = new TreeNode(2);
        TreeNode rLRR = new TreeNode(3);
        TreeNode rRL = new TreeNode(5);
        TreeNode rRR = new TreeNode(7);
        TreeNode rRRR= new TreeNode(8);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rLR.right = rLRR;
        rR.left = rRL;
        rR.right = rRR;
        rRR.right = rRRR;
        printBT(root);
        System.out.println();
        TreeNode rootGST = bstToGst(root);
        printBT(rootGST);
    }

    private static TreeNode bstToGst(TreeNode root) {
        bstToGstHelper(root,0);
        return root;
    }

    private static int bstToGstHelper(TreeNode root, int sum) {
        if(root==null){
            return sum;
        }
        sum = bstToGstHelper(root.right,sum);
        sum+=root.val;
        root.val = sum;
        sum = bstToGstHelper(root.left,sum);
        return sum;
    }
}
