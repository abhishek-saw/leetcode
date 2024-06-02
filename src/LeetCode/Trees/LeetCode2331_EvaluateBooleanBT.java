package Trees;

public class LeetCode2331_EvaluateBooleanBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(3);
        TreeNode rRL = new TreeNode(0);
        TreeNode rRR = new TreeNode(1);
        root.left = rL;
        root.right = rR;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println(evaluateTree(root));
    }

    private static boolean evaluateTree(TreeNode root) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val==1;
        }
        if(root.val==2) {
           return evaluateTree(root.left) || evaluateTree(root.right);
        }
        else if(root.val==3) {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        else {
        return false;
        }
    }

    public static void printBT(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ": ");
        if (root.left != null) {
            System.out.print("L" + root.left.val);
        }
        if (root.right != null) {
            System.out.print(",R" + root.right.val);
        }
        System.out.println();
        printBT(root.left);
        printBT(root.right);
    }

}
