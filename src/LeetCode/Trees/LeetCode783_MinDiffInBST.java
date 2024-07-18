package Trees;

import java.util.ArrayList;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode783_MinDiffInBST {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(6);
        TreeNode rLL1 = new TreeNode(1);
        TreeNode rLR1 = new TreeNode(3);
        root1.left = rL1;
        root1.right = rR1;
        rL1.left = rLL1;
        rL1.right = rLR1;
        printBT(root1);
        System.out.println("Answer : "+minDiffInBST(root1));
    }

    private static int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        System.out.println(list);
        int diff = Integer.MAX_VALUE;
        for(int i =0;i<list.size()-1;i++){
            diff = Math.min(diff,list.get(i+1)-list.get(i));
        }
        return diff;
    }

    private static void inOrder(TreeNode root, ArrayList<Integer> list) {
        if(root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
