class Solution {
    public int numSimilarGroups(String[] strs) {
        int N = strs.length;
        DSU dsu = new DSU(N);
        for (int i=0; i<N-1; i++) {
            String s = strs[i];
            for (int j=i+1; j<N; j++) {
                String t = strs[j];
                if (similar(s, t)) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.comps();
    }

    private boolean similar(String s, String t) {
        int diff = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
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
        }
    }
    
    public int comps(){
        return count;
    }
}