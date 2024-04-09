package Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
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
        List<Integer> answer = inorderTraversal(root);
        System.out.println(answer);
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        return inorderTraversalHelper(root,answer);

    }

    private static List<Integer> inorderTraversalHelper(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left != null) {
            answer = inorderTraversalHelper(root.left, answer);
        }
        answer.add(root.val);
        if (root.right != null) {
            answer = inorderTraversalHelper(root.right, answer);
        }
        return answer;
    }
}