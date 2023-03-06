class Solution {
    public int minJumps(int[] arr) {
        int N = arr.length;
        Map<Integer, List<Integer>> graph = new HashMap();

        for (int i = 0; i < N; i++) {
            graph.computeIfAbsent(arr[i], value -> new LinkedList<Integer>()).add(i);
        }

        List<Integer> q = new LinkedList();
        q.add(0);
        int steps = 0;
        Set<Integer> visited = new HashSet();
        visited.add(0);

        while (!q.isEmpty()) {
            List<Integer> new_q = new LinkedList();
            for (int node: q) {
                if (node == N - 1) {
                    return steps;
                }
                // check the indices that i-th can jump to
                for (int child: graph.get(arr[node])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        new_q.add(child);
                    }
                }

                // clear the list to prevent re-visiting
                graph.get(arr[node]).clear();

                // check the left and right neighbors
                if (node + 1 < N && !visited.contains(node + 1)) {
                    visited.add(node + 1);
                    new_q.add(node + 1);
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1);
                    new_q.add(node - 1);
                }
            }

            q = new_q;
            steps++;
        }

        return -1;
    }
}