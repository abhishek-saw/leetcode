package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode129_SumRootLeaf {
    static int total = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rL = new TreeNode(9);
        TreeNode rR = new TreeNode(0);
        TreeNode rLL = new TreeNode(5);
        TreeNode rLR = new TreeNode(1);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        printBT(root);
        System.out.println();
        TreeNode root1 = new TreeNode(1);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(3);
        root1.left = rL1;
        root1.right = rR1;
        printBT(root1);
        System.out.println(sumNumbers(root));
        System.out.println(sumNumbers(root1));
        System.out.println(sumNumbersDFS(root));
        total=0;
        System.out.println(sumNumbersDFS(root1));
    }

    private static int sumNumbersDFS(TreeNode root) {
        sumsDFS(root,0);
        return total;
    }

    private static void sumsDFS(TreeNode root, int sum) {
        if(root==null){
            return;
        }
        sum =sum*10 + root.val;
        if(root.left==null && root.right==null){
            total+=sum;
            return;
        }
        sumsDFS(root.left,sum);
        sumsDFS(root.right,sum);
    }

    private static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private static int sumNumbersHelper(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return sum*10 + root.val;
        }
        return sumNumbersHelper(root.left, sum*10+root.val) + sumNumbersHelper(root.right, sum*10+root.val);
    }
}