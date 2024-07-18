package Trees;

import java.util.*;

import static Trees.LeetCode2331_EvaluateBooleanBT.printBT;

public class LeetCode1530_GoodLeafNodesPairs {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode rL1 = new TreeNode(2);
        TreeNode rR1 = new TreeNode(3);
        TreeNode rLR1 = new TreeNode(4);
        root1.left = rL1;
        root1.right = rR1;
        rL1.right = rLR1;
        printBT(root1);
        System.out.println();
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
        printBT(root);
        System.out.println();
        System.out.println(countPairs(root1,3));
        System.out.println(countPairs(root,3));
        System.out.println(countPairsPost(root1,3));
        System.out.println(countPairsPost(root,3));

    }

    private static int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();

        traverseTree(root, null, graph, leafNodes);

        int ans = 0;

        for (TreeNode leaf : leafNodes) {
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            bfsQueue.add(leaf);
            seen.add(leaf);
            // Go through all nodes that are within the given distance of
            // the current leaf node
            for (int i = 0; i <= distance; i++) {
                // Clear all nodes in the queue (distance i away from leaf node)
                // Add the nodes' neighbors (distance i+1 away from leaf node)
                int size = bfsQueue.size();
                for (int j = 0; j < size; j++) {
                    // If current node is a new leaf node, add the found pair to our count
                    TreeNode currNode = bfsQueue.remove();
                    if (leafNodes.contains(currNode) && currNode != leaf) {
                        ans++;
                    }
                    if (graph.containsKey(currNode)) {
                        for (TreeNode neighbor : graph.get(currNode)) {
                            if (!seen.contains(neighbor)) {
                                bfsQueue.add(neighbor);
                                seen.add(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return ans / 2;
    }
    private static void traverseTree(TreeNode currNode, TreeNode prevNode, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leafNodes) {
        if (currNode == null) {
            return;
        }
        if (currNode.left == null && currNode.right == null) {
            leafNodes.add(currNode);
        }
        if (prevNode != null) {
            graph.computeIfAbsent(prevNode, k -> new ArrayList<>());
            graph.get(prevNode).add(currNode);
            graph.computeIfAbsent(currNode, k -> new ArrayList<>());
            graph.get(currNode).add(prevNode);
        }
        traverseTree(currNode.left, currNode, graph, leafNodes);
        traverseTree(currNode.right, currNode, graph, leafNodes);
    }
    public static int countPairsPost(TreeNode root, int distance) {
        return postOrder(root, distance)[11];
    }

    private static int[] postOrder(TreeNode currentNode, int distance) {
        if (currentNode == null) {
            return new int[12];
        }
        else if (currentNode.left == null && currentNode.right == null) {
            int[] current = new int[12];
            // Leaf node's distance from itself is 0
            current[0] = 1;
            return current;
        }
        // Leaf node count for a given distance i
        int[] left = postOrder(currentNode.left, distance);
        int[] right = postOrder(currentNode.right, distance);

        int[] current = new int[12];

        // Combine the counts from the left and right subtree and shift by
        // +1 distance
        for (int i = 0; i < 10; i++) {
            current[i + 1] += left[i] + right[i];
        }

        // Initialize to total number of good leaf nodes pairs from left and right subtrees.
        current[11] += left[11] + right[11];

        // Iterate through possible leaf node distance pairs
        for (int d1 = 0; d1 <= distance; d1++) {
            for (int d2 = 0; d2 <= distance; d2++) {
                if (2 + d1 + d2 <= distance) {
                    // If the total path distance is less than the given distance limit,
                    // then add to the total number of good pairs
                    current[11] += left[d1] * right[d2];
                }
            }
        }

        return current;
    }
}