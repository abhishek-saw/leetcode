package Trees;


import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode979_DistributeCoinsBT {
    static int moves = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode rL = new TreeNode(0);
        TreeNode rR = new TreeNode(0);
        TreeNode rLL = new TreeNode(0);
        TreeNode rLR = new TreeNode(0);
        TreeNode rRR = new TreeNode(0);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.right = rRR;
        printBT(root);
        System.out.println("Coin Distribution : " + distributeCoins(root));
    }

    private static int distributeCoins(TreeNode root) {
        distributeCoinsHelper(root);
        return moves;
    }
    private static int distributeCoinsHelper(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftTree = distributeCoinsHelper(root.left);
        int rightTree = distributeCoinsHelper(root.right);
        moves+=Math.abs(leftTree)+Math.abs(rightTree);
        return (leftTree+rightTree+root.val)-1;
    }
}
