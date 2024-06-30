package Graph;

import java.util.ArrayList;
import java.util.List;

public class LeetCode192_GetAncestors {
    public static void main(String[] args) {
        int n1 = 8;
        int [][] edgeList1 = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        int n2 = 8;
        int [][] edgeList2 = {{0,1},{0,2},{0,3},{0,4},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}};
        System.out.println(getAncestors(n1,edgeList1));
        System.out.println(getAncestors(n2,edgeList2));

    }

    private static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> directChild = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            directChild.add(new ArrayList<>());
        }
        for (int[] e : edges)
            directChild.get(e[0]).add(e[1]);
        for (int i = 0; i < n; i++)
            dfs(i, i, ans, directChild);
        return ans;
    }

    private static void dfs(int x, int curr, List<List<Integer>> ans, List<List<Integer>> directChild) {
        for (int ch : directChild.get(curr))
            if (ans.get(ch).isEmpty() || ans.get(ch).get(ans.get(ch).size() - 1) != x) {
                ans.get(ch).add(x);
                dfs(x, ch, ans, directChild);
            }
    }
}