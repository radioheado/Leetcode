class Solution {
    
    private int[] root;
    private int[] rank;
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        
        // initialize DSU
        root = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            root[i] = i;
            rank[i] = 0;
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            union(u, v);
            //System.out.println("root[u] = " + root[u] + ", rank[u] = " + rank[u]);
            //System.out.println("root[v] = " + root[v] + ", rank[v] = " + rank[v]);
        }
        
        //System.out.println("root[start] = " + root[start] + ", root[end] = " + root[end]);
        //System.out.println("find(start) = " + find(start) + ", find(end) = " + find(end));
        
        return find(start) == find(end);
        
    }
    
    private int find(int x){
        return (x==root[x]) ? x : (root[x]=find(root[x]));
    }
    
    private void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        
        if(rootx != rooty){
            
            if(rank[rootx] < rank[rooty]){
                root[rootx] = rooty;
            }else if(rank[rootx] > rank[rooty]){
                root[rooty] = rootx;
            }else{
                root[rootx] = rooty;
                rank[rooty]++;
            }
        }
    }
    
}