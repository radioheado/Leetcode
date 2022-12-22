class Solution {
    private int[] colors;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new int[n + 1];
        Arrays.fill(colors, -1);
        Map<Integer, List<Integer>> ds = new HashMap();

        for (int[] d: dislikes) {
            if (!ds.containsKey(d[0])) {
                ds.put(d[0], new ArrayList());
            }
            if (!ds.containsKey(d[1])) {
                ds.put(d[1], new ArrayList());
            }
            ds.get(d[0]).add(d[1]);
            ds.get(d[1]).add(d[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, ds)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int node, Map<Integer, List<Integer>> ds){
        Queue<Integer> q = new LinkedList();
        q.offer(node);
        colors[node] = 0;

        while (!q.isEmpty()) {
            node = q.poll();
            if (!ds.containsKey(node)) {
                continue;
            }
            for (int nei: ds.get(node)) {
                if (colors[nei] == colors[node]) {
                    return false;
                }
                if (colors[nei] == -1) {
                    colors[nei] = 1- colors[node];
                    q.offer(nei);
                }
            }
        }

        return true;
    }
}