package Trees;

import java.util.ArrayList;

public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rL = new TreeNode(3);
        TreeNode rR = new TreeNode(6);
        TreeNode rLL = new TreeNode(2);
        TreeNode rLR = new TreeNode(4);
        TreeNode rLLL = new TreeNode(1);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rLL.left = rLLL;
        print(root);
        System.out.println();
        System.out.println(kthSmallest(root, 3));
        System.out.println(kthSmallestBetter(root,3));
    }
    public static int kthSmallestBetter(TreeNode root, int k) {
        int left = nodeCount(root.left);  // this value can be saved in the root node
        if (left + 1 == k) {
            return root.val;
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }
    private static int nodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }
    public static int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        return kthSmallestHelper(root,path).get(k-1);
    }
    private static ArrayList<Integer> kthSmallestHelper(TreeNode root, ArrayList<Integer> path) {
        if(root==null){
            return path;
        }
        path = kthSmallestHelper(root.left,path);
        path.add(root.val);
        path = kthSmallestHelper(root.right,path);
        return path;
    }
    public static void print(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        print(treeNode.left);
        System.out.print(treeNode.val+" ");
        print(treeNode.right);
    }
}