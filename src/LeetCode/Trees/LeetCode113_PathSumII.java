package Trees;

import java.util.ArrayList;
import java.util.List;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode113_PathSumII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rL = new TreeNode(4);
        TreeNode rR = new TreeNode(8);
        TreeNode rLL = new TreeNode(11);
        TreeNode rRL = new TreeNode(13);
        TreeNode rRR = new TreeNode(4);
        TreeNode rLLL = new TreeNode(7);
        TreeNode rLLR = new TreeNode(2);
        TreeNode rRRL = new TreeNode(5);
        TreeNode rRRR = new TreeNode(1);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rR.left = rRL;
        rR.right = rRR;
        rLL.left = rLLL;
        rLL.right = rLLR;
        rRR.left = rRRL;
        rRR.right = rRRR;
        printBT(root);
        System.out.println();
        TreeNode root1 = new TreeNode(1);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(3);
        root1.left = rL1;
        root1.right = rR1;
        printBT(root1);
        System.out.println();
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        printBT(root2);
        System.out.println();

        System.out.println(pathSum(root, 22));
        System.out.println(pathSum(root1, 3));
        System.out.println(pathSum(root2, 0));

    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSumHelper(root,targetSum,0,new ArrayList<>(),paths);
        return paths;
    }

    private static void pathSumHelper(TreeNode root, int targetSum, int sum, ArrayList<Integer> curr, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == sum + root.val) {
                curr.add(root.val);
                paths.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
        }
        curr.add(root.val);
        pathSumHelper(root.left, targetSum, sum + root.val, curr, paths);
        pathSumHelper(root.right, targetSum, sum + root.val, curr, paths);
        curr.remove(curr.size() - 1);
    }
}
