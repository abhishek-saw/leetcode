package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode106_BuildBTPostIn {
    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(postorder,inorder);
        printBT(root);
    }

    private static TreeNode buildTree(int[] postorder, int[] inorder) {
        return buildTreeHelper(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if(postStart>postEnd || inStart>inEnd){
            return null;
        }

        int index = inStart;
        while (index<=inEnd){
            if(inorder[index]==postorder[postEnd]) {
                break;
            }
            index++;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left =  buildTreeHelper(postorder,postStart,postStart+index-1-inStart,inorder,inStart,index-1);
        root.right =  buildTreeHelper(postorder,postStart+index-inStart,postEnd-1,inorder,index+1,inEnd);

        return root;
    }
}
