class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU();
        
        int x, y;
        for (String e: equations) {
            if (e.charAt(1) == '=') {
                x = e.charAt(0) - 'a';
                y = e.charAt(3) - 'a';
                dsu.union(x, y);
            }
        }
        
        for (String e: equations) {
            if (e.charAt(1) == '!') {
                x = e.charAt(0) - 'a';
                y = e.charAt(3) - 'a';
                
                if (dsu.find(x) == dsu.find(y)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class DSU{
    int[] root;
    int[] rank;
    
    DSU(){
        root = new int[26];
        rank = new int[26];
        
        for(int i=0; i<26; i++){
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