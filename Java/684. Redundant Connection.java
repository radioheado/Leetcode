class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length + 1);
        for (int[] edge: edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }
}

class DSU{
    int[] root;
    int[] rank;
    int count;
    
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
        return (x==root[x]) ? x : (root[x]=find(root[x]));
    }
    
    // merge two roots
    public boolean union(int a, int b){
        int x = find(a);
        int y = find(b);

        // different roots, need to merge one to another who has larger rank
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
        } else {
            return false;
        }
        return true;
    }
    
    // return the count
    public int getCount(){
        return count;
    }
}