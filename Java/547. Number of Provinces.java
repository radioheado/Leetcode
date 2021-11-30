class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        DSU dsu = new DSU(len);
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        
        return dsu.getCount();
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
    public void union(int a, int b){
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
        }
    }
    
    // return the count
    public int getCount(){
        return count;
    }
}