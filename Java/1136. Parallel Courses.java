class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegrees = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        /* record the adjacency info */
        for (int[] edge: relations) {
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<Integer>());
            }
            adj.get(edge[0]).add(edge[1]);
            indegrees[edge[1]-1]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        /* add all starting courses to the queue */
        for (int i=0; i<n; i++) {
            if (indegrees[i] == 0) {
                q.offer(i+1);
            }
        }
        
        int ans = 0, studied = 0, size;
        while (!q.isEmpty()) {
            ans++;
            Queue<Integer> temp = new LinkedList<>();
            for (int node: q) {
                studied++;
                List<Integer> neis = adj.getOrDefault(node, new ArrayList<Integer>());
                for (int nei: neis) {
                    indegrees[nei-1]--;
                    if (indegrees[nei-1] == 0) {
                        temp.offer(nei);
                    }
                }
            }
            q = temp;
        }
        
        return studied == n ? ans : -1;
    }
}