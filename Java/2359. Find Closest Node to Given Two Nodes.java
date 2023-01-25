class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = bfs(edges, node1);
        int[] dist2 = bfs(edges, node2);
        int[] ans = new int[]{-1, Integer.MAX_VALUE};

        int d1, d2;
        for (int i=0; i<edges.length; i++) {
            d1 = dist1[i];
            d2 = dist2[i];
            if (Math.max(d1, d2) < ans[1]) {
                ans[0] = i;
                ans[1] = Math.max(d1, d2);
            }
        }

        return ans[0];
    }

    private int[] bfs(int[] edges, int node) {
        int N = edges.length, nei;
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[node] = 0;
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        Queue<Integer> q = new LinkedList();
        q.offer(node);

        while (!q.isEmpty()) {
            node = q.poll();
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            nei = edges[node];
            if (nei != -1 && !visited[nei]) {
                distance[nei] = distance[node] + 1;
                q.offer(nei);
            }
        }

        return distance;
    }
}