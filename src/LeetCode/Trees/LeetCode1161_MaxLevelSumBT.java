package Trees;

import java.util.LinkedList;
import java.util.Queue;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1161_MaxLevelSumBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(7);
        TreeNode rR = new TreeNode(0);
        TreeNode rLL = new TreeNode(7);
        TreeNode rLR = new TreeNode(-8);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        printBT(root);
        System.out.println();
        TreeNode root1 = new TreeNode(989);
        TreeNode rR1 = new TreeNode(10250);
        TreeNode rRL1 = new TreeNode(98693);
        TreeNode rRR1 = new TreeNode(-89388);
        TreeNode rRRR1 = new TreeNode(-32127);
        root1.right = rR1;
        rR1.left = rRL1;
        rR1.right = rRR1;
        rRR1.right = rRRR1;
        printBT(root1);
        System.out.println();
        System.out.println(maxLevelSum(root));
        System.out.println(maxLevelSum(root1));
    }

    private static int maxLevelSum(TreeNode root) {
        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i = 0;i<size;i++){
                TreeNode curr = queue.poll();
                assert curr != null;
                sum+=curr.val;
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            level++;
            if(sum>maxSum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        System.out.println(maxSum);
        return maxLevel;
    }
}
