package Trees;

public class DiameterOfBinaryTree {
    private static int diameterTree;
    public static class DiameterReturn{
        int height;
        int diameter;
        DiameterReturn(int height,int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
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
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTreeBetter(root).diameter);
        System.out.println(diameterOfBinaryTreeBest(root));
    }
    private static int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }
    private static int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int height = leftHeight + rightHeight;
        int leftOutput = diameterOfBinaryTree(root.left);
        int rightOutput = diameterOfBinaryTree(root.right);
        return Math.max(Math.max(leftOutput,rightOutput),height);
    }
    private static DiameterReturn diameterOfBinaryTreeBetter(TreeNode root) {
        if(root==null){
            return new DiameterReturn(0,0);
        }
        DiameterReturn leftOutput = diameterOfBinaryTreeBetter(root.left);
        DiameterReturn rightOutput = diameterOfBinaryTreeBetter(root.right);
        int height = 1 + Math.max(leftOutput.height,rightOutput.height);
        int diameter = Math.max(leftOutput.height + rightOutput.height,Math.max(leftOutput.diameter,rightOutput.diameter));
        return new DiameterReturn(height,diameter);
    }
    public static int diameterOfBinaryTreeBest(TreeNode root) {
        maxDiameter(root);
        return diameterTree;
    }
    public static int maxDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_height = maxDiameter(root.left);
        int right_height = maxDiameter(root.right);

        if(left_height + right_height > diameterTree){
            diameterTree = left_height + right_height;
        }
        return 1 + Math.max(left_height,right_height);
    }
}
