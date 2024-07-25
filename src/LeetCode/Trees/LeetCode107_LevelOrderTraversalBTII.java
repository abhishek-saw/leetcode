package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode107_LevelOrderTraversalBTII {
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
        System.out.println(levelOrder(root));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levels = queue.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < levels; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                currList.add(node.val);
            }
            answer.add(0, currList);
        }
        return answer;
    }
}