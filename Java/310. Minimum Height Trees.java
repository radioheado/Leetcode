class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++)
                ans.add(i);
            return ans;
        }

        // build the adjacency list
        List<Set<Integer>> adjs = new ArrayList();
        for (int i=0; i<n; i++) {
            adjs.add(new HashSet());
        }

        for (int[] edge: edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }

        // initialize the first layer of leaves
        List<Integer> leaves = new ArrayList();
        for (int i=0; i<n; i++) {
            if (adjs.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remaining = n, size, nei;
        while (remaining > 2) {
            size = leaves.size();
            remaining -= size;
            List<Integer> next_leaves = new ArrayList();

            // remove current leaf node and its edge
            for (int leaf: leaves) {
                nei = adjs.get(leaf).iterator().next();
                adjs.get(nei).remove(leaf);
                if (adjs.get(nei).size() == 1) {
                    next_leaves.add(nei);
                }
            }
            leaves = next_leaves;
        }

        return leaves;
    }
}