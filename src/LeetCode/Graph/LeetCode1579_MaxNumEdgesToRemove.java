package Graph;

public class LeetCode1579_MaxNumEdgesToRemove {
    public static void main(String[] args) {
        int n1 = 4;
        int [][]edges1 = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,},{2,3,4}};
        int n2 = 4;
        int [][]edges2 = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        System.out.println(maxNumEdgesToRemove(n1,edges1));
        System.out.println(maxNumEdgesToRemove(n2,edges2));
    }

    private static int maxNumEdgesToRemove(int n, int[][] edges) {
        UF a = new UF(n + 1);
        UF b = new UF(n + 1);
        int extra = 0;
        for (int[] e: edges) {
            if (e[0] != 3) continue;
            boolean ext = !a.add(e);
            if (!b.add(e)) ext = true;
            if (ext) extra++;
        }
        for (int[] e: edges) {
            if (e[0] == 1 && !a.add(e)) extra++;
            if (e[0] == 2 && !b.add(e)) extra++;
        }
        return a.isConnected() && b.isConnected() ? extra : -1;
    }
}

