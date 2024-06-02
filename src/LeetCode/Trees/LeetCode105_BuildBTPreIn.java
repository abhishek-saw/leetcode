package Trees;

public class LeetCode105_BuildBTPreIn {
    public static void main(String[] args) {
       int[] preorder = {3,9,20,15,7};
       int[] inorder = {9,3,15,20,7};
       TreeNode root = buildTree(preorder,inorder);
       printBT(root);
    }

    private static void printBT(TreeNode root) {
        if (root==null){
            return;
        }
        System.out.print(root.val + " ");
        printBT(root.left);
        printBT(root.right);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }
        int rootData = preorder[pStart];
        int count = 0;
        for(int i =iStart;i<=iEnd;i++){
            if(rootData == inorder[i]){
                count=i;
            }
        }
        TreeNode root = new TreeNode();
        root.val = rootData;
        root.left = buildTreeHelper(preorder,pStart+1,pStart+count-iStart,inorder,iStart,count-1);
        root.right = buildTreeHelper(preorder,pStart+count-iStart+1,pEnd,inorder,count+1,iEnd);
        return root;

    }

}