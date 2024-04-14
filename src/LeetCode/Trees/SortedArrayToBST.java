package Trees;

import java.util.Arrays;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        System.out.println(Arrays.toString(nums));
        TreeNode answer = sortedArrayToBST(nums);
        printBT(answer);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length-1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = start + (end -start)/2;
        TreeNode  root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums,start,mid-1);
        root.right = sortedArrayToBSTHelper(nums,mid+1,end);
        return root;
    }

    private static void printBT(TreeNode root) {
        if (root == null) {
            return;
        }
        printBT(root.left);
        System.out.print(root.val + " ");
        printBT(root.right);
    }
}
