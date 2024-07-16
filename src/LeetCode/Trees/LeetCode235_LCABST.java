package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode235_LCABST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(8);
        TreeNode rLL = new TreeNode(0);
        TreeNode rLR = new TreeNode(4);
        TreeNode rRL = new TreeNode(7);
        TreeNode rRR = new TreeNode(9);
        TreeNode rLRL = new TreeNode(3);
        TreeNode rLRR = new TreeNode(5);
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
        System.out.println((("LCA : "+ getLCA(root,rL,rLR).val)));
    }

    private static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
        return getLCAHelper(root,p.val,q.val);
    }
    private static TreeNode getLCAHelper(TreeNode root, int a, int b) {
        if(root==null || root.val==a||root.val==b){
            return root;
        }
        if(root.val>a && root.val>b){
            return getLCAHelper(root.left,a,b);
        }
        else if(root.val<a && root.val<b){
            return getLCAHelper(root.right,a,b);
        }
        TreeNode leftLCA = getLCAHelper(root.left, a, b);
        TreeNode rightLCA = getLCAHelper(root.right, a, b);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }
}