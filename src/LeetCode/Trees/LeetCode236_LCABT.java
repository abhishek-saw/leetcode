package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode236_LCABT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rL = new TreeNode(5);
        TreeNode rR = new TreeNode(1);
        TreeNode rLL = new TreeNode(6);
        TreeNode rLR = new TreeNode(2);
        TreeNode rRL = new TreeNode(0);
        TreeNode rRR = new TreeNode(8);
        TreeNode rLRL = new TreeNode(7);
        TreeNode rLRR = new TreeNode(4);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        rR.right = rRR;
        rLR.left = rLRL;
        rLR.right = rLRR;
        printBT(root);
        System.out.println((("LCA : "+ getLCA(root,rL,rR).val)));
        System.out.println((("LCA : "+ getLCA(root,rL,rLRR).val)));
    }

    private static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
        return getLCAHelper(root,p.val,q.val);
    }
    private static TreeNode getLCAHelper(TreeNode root, int a, int b) {
        if(root==null || root.val==a||root.val==b){
            return root;
        }
        TreeNode leftLCA = getLCAHelper(root.left,a,b);
        TreeNode rightLCA = getLCAHelper(root.right,a,b);
        if (leftLCA!=null && rightLCA!=null) {
            return root;
        }
        return leftLCA!=null ? leftLCA:rightLCA;
    }
}