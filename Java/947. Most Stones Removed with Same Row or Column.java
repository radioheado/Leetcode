class Solution {
    private final int K = 10001;
    private int[] visited;
    private List<Integer>[] adj;
    
    public int removeStones(int[][] stones) {
        visited = new int[2 * K + 1];
        adj = new ArrayList[2 * K + 1];
        
        /* initialize the adjacency list */
        for (int i=0; i<2*K+1; i++) {
            adj[i] = new ArrayList();
        }
        
        for (int[] stone: stones) {
            int r = stone[0];
            int c = stone[1] + K;
            adj[r].add(c);
            adj[c].add(r);
        }
        
        int component = 0;
        for (int i=0; i<2*K+1; i++) {
            /* the stone is not visited and has adjacents */
            if (visited[i] == 0 && !adj[i].isEmpty()) {
                component++;
                dfs(stones, i);
            }
        }
        
        return stones.length - component;
    }
    
    private void dfs(int[][] stones, int stone) {
        visited[stone] = 1;
        for (int a: adj[stone]) {
            if (visited[a] == 0) {
                dfs(stones, a);
            }
        }
    }
}