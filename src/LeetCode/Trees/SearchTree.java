package Trees;

import static Trees.KthSmallestElement.print;

public class SearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(6);
        TreeNode rLL = new TreeNode(3);
        TreeNode rLR = new TreeNode(1);
        TreeNode rRL = new TreeNode(5);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        print(root);
        int val = 6;
        System.out.println();
        TreeNode answer = searchBST(root,val);
        print(answer);
    }

    private static TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode left = searchBST(root.left,val);
        if(left!=null){
            return left;
        }
        TreeNode right = searchBST(root.right,val);
        if(right!=null){
            return right;
        }
        else {
            return null;
        }
    }
}