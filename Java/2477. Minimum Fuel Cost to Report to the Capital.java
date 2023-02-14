class Solution {
    private Map<Integer, List<Integer>> adjs;
    private long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        adjs = new HashMap();
        ans = 0;

        for (int[] r: roads) {
            adjs.computeIfAbsent(r[0], value -> new ArrayList()).add(r[1]);
            adjs.computeIfAbsent(r[1], value -> new ArrayList()).add(r[0]);
        }

        dfs(roads, seats, 0, -1);
        return ans;
    }

    private long dfs(int[][] roads, int seats, int node, int parent) {
        long rep = 1;

        if (adjs.containsKey(node)) {
            for (int a: adjs.get(node)) {
                if (a != parent) {
                    rep += dfs(roads, seats, a, node);
                }
            }
        }
        
        if (node != 0) {
            ans += Math.ceil((double)rep / seats);
        }

        return rep;
    }
}