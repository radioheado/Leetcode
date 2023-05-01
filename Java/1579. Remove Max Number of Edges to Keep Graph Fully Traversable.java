class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob   = new DSU(n);
        int needed = 0;

        for (int[] edge: edges) {
            if (edge[0] == 3) {
                needed += alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]);
            }
        }

        for (int[] edge: edges) {
            if (edge[0] == 1) {
                needed += alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                needed += bob.union(edge[1], edge[2]);
            }
        }

        return alice.connected() && bob.connected() ? edges.length - needed : -1;
    }
}

class DSU{
    private int[] root;
    private int[] rank;
    private int count;
    
    DSU(int size){
        root = new int[size + 1];
        rank = new int[size + 1];
        count = size;
        
        for(int i=0; i<=size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        return x == root[x] ? x : (root[x] = find(root[x]));
    }
    
    public int union(int a, int b){
        int x = find(a);
        int y = find(b);
        
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
            return 1;
        }

        return 0;
    }
    
    public boolean connected(){
        return count == 1;
    }
}