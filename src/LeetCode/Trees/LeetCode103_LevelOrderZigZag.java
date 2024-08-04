package Trees;

import java.util.*;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode103_LevelOrderZigZag {
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
        System.out.println(zigzagLevelOrder(root));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean bol = true;
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currList = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr!=null) {
                    if(bol) {
                        currList.add(curr.val);
                    }
                    else {
                        currList.add(0,curr.val);
                    }
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            bol = !bol;
            if(!currList.isEmpty()) {
                answer.add(currList);
            }
        }
        return answer;
    }
}
