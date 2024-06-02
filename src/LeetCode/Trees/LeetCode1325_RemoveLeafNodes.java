package Trees;


import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1325_RemoveLeafNodes{ public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode rL = new TreeNode(2);
    TreeNode rR = new TreeNode(3);
    TreeNode rLL = new TreeNode(2);
    TreeNode rRL = new TreeNode(2);
    TreeNode rRR = new TreeNode(4);
    root.left = rL;
    root.right = rR;
    rL.left = rLL;
    rR.left = rRL;
    rR.right = rRR;
    printBT(root);
    System.out.println();
    int target=2;
    printBT(removeLeafNodes(root,target));
}
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return null;
        }
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
//        OR
//        if(root.left!=null) {
//            if(root.left.left==null && root.left.right==null) {
//                if (root.left.val == target) {
//                    root.left = null;
//                }
//            }
//        }
//        if(root.right!=null) {
//            if(root.right.left==null && root.right.right==null) {
//                if (root.right.val == target) {
//                    root.right = null;
//                }
//            }
//        }
//        if(root.val==target){
//            if(root.left==null && root.right==null){
//            return null;
//            }
//        }
        return root;
    }
}
