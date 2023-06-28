class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(new Pair<>(v, p));
            graph.computeIfAbsent(v, value -> new ArrayList<>()).add(new Pair<>(u, p));
        }

        double[] probs = new double[n];
        probs[start] = 1d;
        pq.add(new Pair<>(1.0, start));

        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double prob = cur.getKey();
            int node = cur.getValue();
            if (node == end) {
                return prob;
            }

            for (Pair<Integer, Double> adj: graph.getOrDefault(node, new ArrayList<>())) {
                int a = adj.getKey();
                double p = adj.getValue();
                if (prob * p > probs[a]) {
                    probs[a] = prob * p;
                    pq.add(new Pair<>(probs[a], a));
                }
            }
        }

        return 0d;
    }
}