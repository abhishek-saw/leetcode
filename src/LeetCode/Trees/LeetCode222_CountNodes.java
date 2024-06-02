package Trees;

public class LeetCode222_CountNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRR = new TreeNode(6);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        System.out.println(countNodes(root));
    }

    private static int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}