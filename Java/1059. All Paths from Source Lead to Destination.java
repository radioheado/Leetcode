class Solution {
    Map<Integer, List<Integer>> graph;
    Set<Integer> seen;
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();
        seen = new HashSet<>();
        
        for(int[] edge: edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<Integer>());
            }
            graph.get(edge[0]).add(edge[1]);
            //System.out.println(graph.get(edge[0]));
        }
        
        return dfs(source, destination);
    }
 
    
    private boolean dfs(int node, int dest){
        // found a leaf
        if(!graph.containsKey(node)){
            return node == dest;
        }
        
        for(Integer nei: graph.get(node)){
            if(seen.contains(nei)){
                return false;
            }
            seen.add(nei);
            if(!dfs(nei, dest)){
                return false;
            }
            seen.remove(nei);
        }
        
        return true;
    }
}