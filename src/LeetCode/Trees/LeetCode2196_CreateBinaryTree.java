package Trees;

import java.util.HashMap;


import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode2196_CreateBinaryTree {
    public static void main(String[] args) {
        int [][] descriptions1 = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        int [][] descriptions2 = {{1,2,1},{2,3,0},{3,4,1}};
        int [][] descriptions3 = {{85,82,1},{74,85,1},{39,70,0},{82,38,1},{74,39,0},{39,13,1}};
        printBT(createBinaryTree(descriptions1));
        System.out.println();
        printBT(createBinaryTreeBetter(descriptions1));
        System.out.println();
        printBT(createBinaryTree(descriptions2));
        System.out.println();
        printBT(createBinaryTreeBetter(descriptions2));
        System.out.println();
        printBT(createBinaryTree(descriptions3));
        System.out.println();
        printBT(createBinaryTreeBetter(descriptions3));
    }

    private static TreeNode createBinaryTreeBetter(int[][] descriptions) {
        HashMap<Integer,TreeNode> maps = new HashMap<>();
        for(int [] array: descriptions){
            int parent = array[0];
            int child = array[1];
            int isLeft = array[2];
            TreeNode parentNode = maps.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = maps.getOrDefault(child, new TreeNode(child));
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            maps.put(parent, parentNode);
            maps.put(child, childNode);
        }
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        for (int[] array : descriptions){
            hashMap.put(array[0],true);
        }
        for (int[] array : descriptions){
            hashMap.remove(array[1]);
        }
        int rootV = 0 ;
        for (int k : hashMap.keySet()){
            rootV = k;
        }
        return maps.getOrDefault(rootV, null);
    }

    private static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> maps = new HashMap<>();
        for(int [] array : descriptions){
            int parent = array[0];
            int child = array[1];
            int isLeft = array[2];
            if(!maps.containsKey(parent)) {
                TreeNode treeNode1 = new TreeNode(parent);
                if(!maps.containsKey(child)) {
                    TreeNode treeNode2 = new TreeNode(child);
                    if (isLeft == 0) {
                        treeNode1.right = treeNode2;
                    } else {
                        treeNode1.left = treeNode2;
                    }
                    maps.put(parent, treeNode1);
                    maps.put(child, treeNode2);
                }
                else {
                    TreeNode treeNode2 = maps.get(child);
                    if (isLeft == 0) {
                        treeNode1.right = treeNode2;
                    } else {
                        treeNode1.left = treeNode2;
                    }
                    maps.put(parent, treeNode1);
                }
            }
            else {
                TreeNode treeNode1 = maps.get((parent));
                if(!maps.containsKey(child)) {
                    TreeNode treeNode2 = new TreeNode(child);
                    if (isLeft == 0) {
                        treeNode1.right = treeNode2;
                    } else {
                        treeNode1.left = treeNode2;
                    }
                    maps.put(child, treeNode2);
                }
                else {
                    TreeNode treeNode2 = maps.get((child));
                    if (isLeft == 0) {
                        treeNode1.right = treeNode2;
                    } else {
                        treeNode1.left = treeNode2;
                    }
                }
            }
        }
        HashMap<Integer,Boolean> hashMap = new HashMap<>();
        for (int[] array : descriptions){
            hashMap.put(array[0],true);
        }
        for (int[] array : descriptions){
            hashMap.remove(array[1]);
        }
        int rootV = 0 ;
        for (int k : hashMap.keySet()){
            rootV = k;
        }
        return maps.getOrDefault(rootV, null);
    }
}
