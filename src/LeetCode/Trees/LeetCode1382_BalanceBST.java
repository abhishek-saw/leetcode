package Trees;

import java.util.ArrayList;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1382_BalanceBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rR = new TreeNode(2);
        TreeNode rRR = new TreeNode(3);
        TreeNode rRRR = new TreeNode(4);
        root.right = rR;
        rR.right = rRR;
        rRR.right = rRRR;
        printBT(root);
        TreeNode balanceTree = balanceBST(root);
        printBT(balanceTree);
    }

    private static TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sortedArray = new ArrayList<>();
        bstToArray(root,sortedArray);
        System.out.println(sortedArray);
        return sortedArrayToBST(sortedArray);
    }

    private static TreeNode sortedArrayToBST(ArrayList<Integer> sortedArray) {
        return sortedArrayToBSTHelper(sortedArray,0,sortedArray.size()-1);
    }

    private static TreeNode sortedArrayToBSTHelper(ArrayList<Integer> sortedArray, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = start + (end-start)/2;
        TreeNode newRoot = new TreeNode(sortedArray.get(mid));
        newRoot.left = sortedArrayToBSTHelper(sortedArray,start,mid-1);
        newRoot.right = sortedArrayToBSTHelper(sortedArray,mid+1,end);
        return newRoot;
    }

    private static void bstToArray(TreeNode temp, ArrayList<Integer> sortedArray) {
        if(temp==null){
            return;
        }
        bstToArray(temp.left,sortedArray);
        sortedArray.add(temp.val);
        bstToArray(temp.right,sortedArray);
    }
}
