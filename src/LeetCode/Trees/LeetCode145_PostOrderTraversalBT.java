package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145_PostOrderTraversalBT {
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
        List<Integer> answer = postorderTraversal(root);
        System.out.println(answer);
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        return postorderTraversalHelper(root,answer);
    }

    private static List<Integer> postorderTraversalHelper(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left != null) {
            answer = postorderTraversalHelper(root.left, answer);
        }
        if (root.right != null) {
            answer = postorderTraversalHelper(root.right, answer);
        }
        answer.add(root.val);
        return answer;
    }
}