class Solution {
    public int minScore(int n, int[][] roads) {
        DSU dsu = new DSU(n + 1);

        for (int[] r: roads) {
            dsu.union(r[0], r[1]);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] r: roads) {
            if (dsu.find(1) == dsu.find(r[0])) {
                ans = Math.min(ans, r[2]);
            }
        }

        return ans;
    }
}

class DSU{
    int[] root;
    int[] rank;
    
    DSU(int size){
        root = new int[size];
        rank = new int[size];
        
        for(int i=0; i<size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        return (x==root[x]) ? x : (root[x]=find(root[x]));
    }
    
    // merge two roots
    public void union(int a, int b){
        int x = find(a);
        int y = find(b);
        
        // different roots, need to merge one to another who has larger rank
        if(x != y){
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
    
}