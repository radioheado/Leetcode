class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(dsu.connected(u, v)){
                return false;
            }
            dsu.union(u, v);
        }
        
        return dsu.isTree();
    }
}

class DSU{
    private int[] root;
    private int[] rank;
    private int count;
    
    DSU(int size){
        root = new int[size];
        rank = new int[size];
        count = size;
        
        for(int i=0; i<size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        return x == root[x] ? x : (root[x] = find(root[x]));
    }
    
    public void union(int a, int b){
        int x = root[a];
        int y = root[b];
        
        if(x != y){
            count--;
            if(rank[x] < rank[y]){
                root[x] = y;
            }else if(rank[x] > rank[y]){
                root[y] = x;
            }else{
                root[x] = y;
                rank[y]++;
            }
        }
    }
    
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
    
    public boolean isTree(){
        return count == 1;
    }
}