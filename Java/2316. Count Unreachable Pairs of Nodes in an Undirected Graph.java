class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] e: edges) {
            dsu.union(e[0], e[1]);
        }

        Map<Integer, Integer> comps = new HashMap();
        for (int i=0; i<n; i++) {
            int root = dsu.find(i);
            comps.put(root, comps.getOrDefault(root, 0) + 1);
        }

        long remains = n, ans = 0;
        for (int count: comps.values()) {
            remains -= count;
            ans += count * remains;
        }

        return ans;
    }
}

class DSU {
    private int[] root, rank;

    public DSU(int n) {
        root = new int[n];
        rank = new int[n];
        for (int x=0; x<n; x++) {
            root[x] = x;
        }
    }

    public int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    public void union(int x, int y) {
        int rootx = find(x), rooty = find(y);
        int rankx = rank[x], ranky = rank[y];
        if (rootx != rooty) {
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
}