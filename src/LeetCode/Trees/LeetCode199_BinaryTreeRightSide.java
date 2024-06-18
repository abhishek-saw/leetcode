package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;


public class LeetCode199_BinaryTreeRightSide {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(5);
        TreeNode rRR = new TreeNode(4);
        root.left = rL;
        root.right = rR;
        rL.right = rLL;
        rR.right = rRR;
        printBT(root);
        System.out.println(rightSideViewHelper(root));
        TreeNode root1 = new TreeNode(1);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(3);
        TreeNode rRR1 = new TreeNode(4);
        root1.left = rL1;
        root1.right = rR1;
        rL1.right = rRR1;
        printBT(root1);
        System.out.println(rightSideViewHelper(root1));

    }

    private static List<Integer> rightSideViewHelper(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
           int size = queue.size();
           for(int i =0;i<size;i++){
               TreeNode curr = queue.poll();
               if(i==size-1){
                   answer.add(curr.val);
               }
               if(curr.left!=null){
                   queue.add(curr.left);
               }
               if(curr.right!=null){
                   queue.add(curr.right);
               }
           }
        }
        return answer;
    }
}
