class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        // use this list to save tuples (house_i, house_j, weight)
        List<int[]> weighted_edges = new ArrayList<>(n+1+pipes.length);
        
        // add weights for making a well for a house
        // using a virtual vertex -> house0 to make a virtual edge
        for(int i=0; i<wells.length; ++i){
            weighted_edges.add(new int[]{0, i+1, wells[i]});
        }
        
        // add the costs for laying pipes between two houses
        for(int[] edge : pipes){
            weighted_edges.add(edge);
        }
        
        // sort according to the weights
        Collections.sort(weighted_edges, (a, b) -> a[2] - b[2]);
        
        DSU dsu = new DSU(n);
        int costs = 0;
        
        for(int[] edge : weighted_edges){
            if(dsu.union(edge[0], edge[1])){
                costs += edge[2];
            }
        }
        
        return costs;
    }
}


class DSU{
    private int[] root;
    private int[] rank;
    
    DSU(int size){
        root = new int[size+1];
        rank = new int[size+1];
        
        for(int i=0; i<size+1; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        return (x==root[x]) ? x : (root[x]=find(root[x]));
    }
    
    // merge two roots
    public boolean union(int a, int b){
        int x = find(a);
        int y = find(b);
        
        if(x == y){
            return false;
        }
        
        // different roots, need to merge one to another who has larger rank
        
        if(rank[x] < rank[y]){
            root[x] = y;
        }else if(rank[x] > rank[y]){
            root[y] = x;
        }else{
            root[x] = y;
            rank[y]++;
        }
        
        return true;
    }
    
}