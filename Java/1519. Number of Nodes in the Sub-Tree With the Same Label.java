class Solution {
    private int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adjs = new HashMap();
        for (int[] edge: edges) {
            int a = edge[0], b = edge[1];
            adjs.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adjs.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        ans = new int[n];
        dfs(0, -1, labels.toCharArray(), adjs);
        return ans;
    }

    private int[] dfs(int node, int parent, char[] labels, Map<Integer, List<Integer>> adjs) {
        int[] nodeCount = new int[26];
        nodeCount[labels[node] - 'a'] = 1;

        if (!adjs.containsKey(node)) {
            return nodeCount;
        }

        for (int child: adjs.get(node)) {
            if (child == parent) {
                continue;
            }

            int[] childCount = dfs(child, node, labels, adjs);
            for (int i=0; i<26; i++) {
                nodeCount[i] += childCount[i];
            }
        }

        ans[node] = nodeCount[labels[node] - 'a'];
        return nodeCount;
    }
}