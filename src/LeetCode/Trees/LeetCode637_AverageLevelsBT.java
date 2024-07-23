package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode637_AverageLevelsBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRL = new TreeNode(6);
        TreeNode rRR = new TreeNode(7);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println(averageOfLevels(root));
    }

    private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            double level = 0;
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                sum+=node.val;
                level++;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            answer.add(sum/level);
        }
        return answer;
    }
}
