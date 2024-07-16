package Trees;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode2096_GetDirectionsBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rL = new TreeNode(1);
        TreeNode rR = new TreeNode(2);
        TreeNode rLL = new TreeNode(3);
        TreeNode rRL = new TreeNode(6);
        TreeNode rRR = new TreeNode(4);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rR.left = rRL;
        rR.right = rRR;
        printBT(root);
        System.out.println(getDirections(root,3,6));
        System.out.println(getDirectionsBetter(root,3,6));
        System.out.println();
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        printBT(root1);
        System.out.println(getDirections(root1,2,1));
        System.out.println(getDirectionsBetter(root1,2,1));

    }

    private static String getDirectionsBetter(TreeNode root, int startValue, int destValue) {
        StringBuilder path1 = new StringBuilder();
        findPath(root,startValue,path1);
        StringBuilder path2 = new StringBuilder();
        findPath(root,destValue,path2);
        int idx = 0;
        while (idx<path1.length() && idx<path2.length()){
            if(path1.charAt(idx)==path2.charAt(idx)){
                idx++;
            }
            else {
                break;
            }
        }
        path1 = new StringBuilder(path1.substring(idx));
        StringBuilder path = new StringBuilder();
        for (char ignored : path1.toString().toCharArray()){
            path.append("U");
        }
        return path.append(path2.substring(idx)).toString();
    }
    private static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLCA(root,startValue,destValue);
        System.out.println((("LCA : "+ lca.val)));
        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();
        findPath(lca,startValue, path1);
        findPath(lca,destValue, path2);
        StringBuilder path = new StringBuilder();
        for (char ignored : path1.toString().toCharArray()){
            path.append("U");
        }
        return path.append(path2).toString();
    }
    private static boolean findPath(TreeNode lca, int target, StringBuilder path) {
        if(lca==null){
            return false;
        }
        if(lca.val==target){
            return true;
        }
        path.append('L');
        if(findPath(lca.left,target,path)) {
            return true;
        }
        path.deleteCharAt(path.length()-1);
        path.append('R');
        if(findPath(lca.right,target,path)) {
            return true;
        }
        path.deleteCharAt(path.length()-1);
        return false;
    }
    private static TreeNode getLCA(TreeNode root, int a, int b) {
        if(root==null || root.val==a||root.val==b){
            return root;
        }
        TreeNode leftLCA = getLCA(root.left,a,b);
        TreeNode rightLCA = getLCA(root.right,a,b);
        if (leftLCA!=null && rightLCA!=null) {
            return root;
        }
        return leftLCA!=null ? leftLCA:rightLCA;
    }
}