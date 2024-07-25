package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode515_LargestValues {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rL = new TreeNode(9);
        TreeNode rR = new TreeNode(20);
        TreeNode rRL = new TreeNode(15);
        TreeNode rRR = new TreeNode(7);
        root.left = rL;
        root.right = rR;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println(largestValues(root));
    }

    private static List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                max = Math.max(max, node.val);
            }
            list.add(max);
        }
        return list;
    }
}
