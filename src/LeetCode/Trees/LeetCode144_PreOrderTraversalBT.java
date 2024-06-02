package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144_PreOrderTraversalBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRR = new TreeNode(6);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        List<Integer> answer = preorderTraversal(root);
        System.out.println(answer);
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        return preorderTraversalHelper(root,answer);
    }

    private static List<Integer> preorderTraversalHelper(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return new ArrayList<>();
        }
        answer.add(root.val);
        if (root.left != null) {
            answer = preorderTraversalHelper(root.left, answer);
        }
        if (root.right != null) {
            answer = preorderTraversalHelper(root.right, answer);
        }
        return answer;
    }
}