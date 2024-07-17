package Trees;

import java.util.*;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1110_DeleteNodesReturnForest {
    static List<TreeNode> forest;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rL = new TreeNode(2);
        TreeNode rR = new TreeNode(3);
        TreeNode rLL = new TreeNode(4);
        TreeNode rLR = new TreeNode(5);
        TreeNode rRL = new TreeNode(6);
        TreeNode rRR = new TreeNode(7);
        root.left = rL;
        root.right = rR;
        rL.left = rLL;
        rL.right = rLR;
        rR.left = rRL;
        rR.right = rRR;
        int[] to_delete = {3, 5};
        printBT(root);
        System.out.println();

        TreeNode root1 = new TreeNode(1);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(3);
        TreeNode rLR1 = new TreeNode(4);
        root1.left = rL1;
        root1.right = rR1;
        rR1.right = rLR1;
        int[] to_delete1 = {2,1};
        printBT(root1);
//        List<TreeNode> answer = delNodes(root, to_delete);
//        List<TreeNode> answer1 = delNodes(root1, to_delete1);
        List<TreeNode> answer = delNodesSimple(root, to_delete);
        List<TreeNode> answer1 = delNodesSimple(root1, to_delete1);
        System.out.println("answer");
        for (TreeNode node : answer) {
            printBT(node);
            System.out.println();
        }
        System.out.println("answer1");
        for (TreeNode node : answer1) {
            printBT(node);
            System.out.println();
        }
    }

    private static List<TreeNode> delNodesSimple(TreeNode root, int[] to_delete) {
        List<TreeNode> forests = new ArrayList<>();
        HashSet<Integer> maps = new HashSet<>();
        for (int n : to_delete) {
            maps.add(n);
        }
        root = dfs(root,maps,forests);
        if(root!=null){
            forests.add(root);
        }
        return forests;
    }

    private static TreeNode dfs(TreeNode root, HashSet<Integer> maps, List<TreeNode> forests) {
        if(root==null){
            return null;
        }
        root.left = dfs(root.left, maps, forests);
        root.right = dfs(root.right, maps, forests);
        if (maps.contains(root.val)) {
            if (root.left != null) {
                forests.add(root.left);
            }
            if (root.right != null) {
                forests.add(root.right);
            }
            return null;
        } else {
            return root;
        }

    }

    private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        HashSet<Integer> maps = new HashSet<>();
        for (int n : to_delete) {
            maps.add(n);
        }
        delNodesHelper(root,null,maps,true);
        return forest;
    }

    private static void delNodesHelper(TreeNode root, TreeNode parent, HashSet<Integer> maps, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (parent == null && !maps.contains(root.val) ) {
            forest.add(root);
        }
        if (maps.contains(root.val)) {
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            delNodesHelper(root.left, null,maps, true);
            delNodesHelper(root.right, null,maps, false);
        } else {
            delNodesHelper(root.left, root,maps, true);
            delNodesHelper(root.right, root,maps, false);
        }
    }
}