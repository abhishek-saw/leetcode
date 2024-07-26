package Graph;

class UF {
    int[] nodes;
    int edjCnt = 0;
    UF(int n) {
        nodes = new int[n];
        for(int i = 0; i < n; i++)
            nodes[i] = i;
    }

    boolean isConnected() {
        return (nodes.length - 1 - 1) == edjCnt;
    }

    boolean add(int[] edj) {
        int aHead = head(edj[1]);
        int bHead = head(edj[2]);
        if (aHead != bHead) {
            nodes[bHead] = aHead;
            edjCnt++;
            return true;
        }
        return false;
    }

    int head(int n) {
        if (n != nodes[n])
            nodes[n] = head(nodes[n]);
        return nodes[n];
    }
}