package Trees;

import java.util.*;

public class LeetCode102_LevelOrderTraversalBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRR = new TreeNode(6);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        System.out.println(levelOrder(root));
        System.out.println(levelOrder2(root));
    }

    private static List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int levels = nodes.size();
            List<Integer> currList = new ArrayList<>();
            for(int i =0;i<levels;i++){
                assert nodes.peek() != null;
                if(nodes.peek().left!=null){
                    nodes.add(nodes.peek().left);
                }
                if(nodes.peek().right!=null){
                    nodes.add(nodes.peek().right);
                }
                currList.add(nodes.remove().val);
            }
            answer.add(currList);
        }
        return answer;
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null){
            return answer;
        }
        Queue<TreeNode> pq = new LinkedList<>();
        pq.add(root);
        pq.add(null);
        answer.add(new ArrayList<>(List.of(root.val)));
        List<Integer> currList = new ArrayList<>();
        while (!pq.isEmpty()){
            TreeNode currNode = pq.poll();
            if(currNode==null){
                if(!pq.isEmpty()){
                    pq.add(null);
                    answer.add(currList);
                    currList = new ArrayList<>();
                }
            }
            else {
                if (currNode.left != null) {
                    currList.add(currNode.left.val);
                    pq.add(currNode.left);
                }
                if (currNode.right != null) {
                    currList.add(currNode.right.val);
                    pq.add(currNode.right);
                }
            }
        }
        return answer;
    }
}
