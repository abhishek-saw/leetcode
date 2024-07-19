package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode450_DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rL = new TreeNode(3);
        TreeNode rR = new TreeNode(6);
        TreeNode rLL = new TreeNode(2);
        TreeNode rLR = new TreeNode(4);
        TreeNode rRR = new TreeNode(7);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        printBT(root);
        System.out.println();
        printBT(deleteNode(root,5));
        System.out.println();
        TreeNode root1 = new TreeNode(50);
        TreeNode rL1 = new TreeNode(30);
        TreeNode rR1 = new TreeNode(70);
        TreeNode rLL1 = new TreeNode(40);
        TreeNode rLR1 = new TreeNode(60);
        TreeNode rRR1 = new TreeNode(80);
        root1.left = rL1;
        root1.right = rR1;
        rL1.right = rLL1;
        rR1.left = rLR1;
        rR1.right = rRR1;
        printBT(root1);
        System.out.println();
        printBT(deleteNode(root1,50));
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if (root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                root.val = curr.val;
                root.right = deleteNode(root.right, curr.val);
                return root;
            }
        }
    }
}