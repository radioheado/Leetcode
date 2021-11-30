class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        DSU dsu = new DSU(n);
        
        for(int[] log : logs){
            dsu.union(log[1], log[2]);
            if(dsu.getCount() == 1){
                return log[0];
            }
        }
        return -1;
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