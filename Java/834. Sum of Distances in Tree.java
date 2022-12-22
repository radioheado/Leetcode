class Solution {
    private int[] count, ans;
    private Map<Integer, List<Integer>> adjs;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        count = new int[n];
        ans = new int[n];
        Arrays.fill(count, 1);
        adjs = new HashMap();

        for (int[] e: edges) {
            if (!adjs.containsKey(e[0])) {
                adjs.put(e[0], new ArrayList<Integer>());
            }
            if (!adjs.containsKey(e[1])) {
                adjs.put(e[1], new ArrayList<Integer>());
            }
            adjs.get(e[0]).add(e[1]);
            adjs.get(e[1]).add(e[0]);
        }

        dfs1(0, -1);
        dfs2(0, -2, n);
        return ans;
    }

    private void dfs1(int node, int parent) {
        for (int child: adjs.getOrDefault(node, new ArrayList<Integer>())) {
            if (child != parent) {
                dfs1(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent, int n) {
        for (int child: adjs.getOrDefault(node, new ArrayList<Integer>())) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + n - count[child];
                dfs2(child, node, n);
            }
        }
    }
}