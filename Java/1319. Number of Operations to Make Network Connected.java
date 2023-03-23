class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        for (int[] c: connections) {
            dsu.union(c[0], c[1]);
        }

        int connect_components = dsu.components() - 1, edges = connections.length;
        return edges >= n - 1 ? connect_components : -1;
    }
}

class DSU {
    private int[] root, rank;
    private int count;

    public DSU(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i=0; i<n; i++) {
            root[i] = i;
        }
        count = n;
    }

    public int find(int x) {
        return x == root[x] ? root[x] : find(root[x]);
    }

    public void union(int x, int y) {
        int rootx = find(x), rooty = find(y);
        int rankx = rank[rootx], ranky = rank[rooty];

        if (rootx != rooty) {
            count--;
            if (rankx > ranky) {
                root[rooty] = rootx;
            } else if (rankx < ranky) {
                root[rootx] = rooty;
            } else {
                root[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public int components() {
        return count;
    }
}