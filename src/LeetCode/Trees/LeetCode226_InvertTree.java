package Trees;


public class LeetCode226_InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(5);
        TreeNode rLL = new TreeNode(3);
        TreeNode rLR = new TreeNode(4);
        TreeNode rRL = new TreeNode(6);
        TreeNode rRR = new TreeNode(7);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println();
        TreeNode answer1 = invertTree(root);
        printBT(answer1);
        System.out.println();
        TreeNode answer2 = invertTreeBetter(root);
        printBT(answer2);
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if(root.left!=null && root.right!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        else if(root.left!=null){
            root.right = root.left;
            root.left = null;
        }
        else {
            root.left = root.right;
            root.right = null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
    private static TreeNode invertTreeBetter(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    private static void printBT(TreeNode root) {
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