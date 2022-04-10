class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(i);
        }
        
        for (List<Integer> edge: edges) {
            set.remove(edge.get(1));
        }
        
        return new ArrayList<>(set);
    }
}