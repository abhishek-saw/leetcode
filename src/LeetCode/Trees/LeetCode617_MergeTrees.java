package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode617_MergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode rL = new TreeNode(3);
        TreeNode rR = new TreeNode(2);
        TreeNode rLL = new TreeNode(5);
        root1.left = rL;
        root1.right = rR;
        rL.left = rLL;
        TreeNode root2 = new TreeNode(2);
        TreeNode sL = new TreeNode(1);
        TreeNode sR = new TreeNode(3);
        TreeNode sLR = new TreeNode(4);
        TreeNode sRR = new TreeNode(7);
        root2.left = sL;
        root2.right = sR;
        sL.right = sLR;
        sR.right = sRR;
        printBT(root1);
        System.out.println();
        printBT(root2);
        System.out.println();
       printBT(mergeTrees(root1,root2));

    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return null;
        }
        if(root1==null) {
            return root2;
        }
        if(root2==null) {
            return root1;
        }
        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
