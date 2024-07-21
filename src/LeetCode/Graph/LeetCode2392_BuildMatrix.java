package Graph;

import java.util.*;

public class LeetCode2392_BuildMatrix {
    public static void main(String[] args) {
        int k1 = 3;
        int[][] rowConditions1 = {{1,2},{3,2}};
        int[][] colConditions1 = {{2,1},{3,2}};
        System.out.println(Arrays.deepToString(buildMatrix(k1, rowConditions1, colConditions1)));
        int k2 = 3;
        int[][] rowConditions2 = {{1,2},{2,3},{3,1},{2,3}};
        int[][] colConditions2 = {{2,1}};
        System.out.println(Arrays.deepToString(buildMatrix(k2, rowConditions2, colConditions2)));

    }

    private static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row_sorting = topo_sort(rowConditions, k);
        List<Integer> col_sorting = topo_sort(colConditions, k);
        if (row_sorting.isEmpty() || col_sorting.isEmpty())
            return new int[0][0];

        Map<Integer, int[]> value_position = new HashMap<>();
        for (int n = 1; n <= k; ++n) {
            value_position.put(n, new int[2]);  // element -> [row_index, col_index]
        }
        for (int ind = 0; ind < row_sorting.size(); ++ind) {
            value_position.get(row_sorting.get(ind))[0] = ind;
        }
        for (int ind = 0; ind < col_sorting.size(); ++ind) {
            value_position.get(col_sorting.get(ind))[1] = ind;
        }

        int[][] res = new int[k][k];
        for (int value = 1; value <= k; ++value) {
            int row = value_position.get(value)[0];
            int column = value_position.get(value)[1];
            res[row][column] = value;
        }

        return res;
    }

    // return True if all okay and return False if cycle was found
    private static boolean dfs(int src, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> cur_path, List<Integer> res) {
        if (cur_path.contains(src)) return false;  // cycle detected
        if (visited.contains(src)) return true;  // all okay, but we've already visited this node

        visited.add(src);
        cur_path.add(src);

        for (int neighbor : graph.getOrDefault(src, Collections.emptyList())) {
            if (!dfs(neighbor, graph, visited, cur_path, res))  // if any child returns false
                return false;
        }

        cur_path.remove(src);  // backtrack path
        res.add(src);
        return true;
    }

    // if there will be cycle - return empty array, in other case return 1d array as described above
    private static List<Integer> topo_sort(int[][] edges, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cur_path = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        for (int src = 1; src <= k; ++src) {
            if (!dfs(src, graph, visited, cur_path, res))
                return Collections.emptyList();
        }

        Collections.reverse(res);  // we will have res as reversed so we need to reverse it one more time
        return res;
    }
}