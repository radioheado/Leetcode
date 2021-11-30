class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU dsu = new DSU(s.length());
        
        /** save the components such that groups of nodes are kept in a key
         *  then we'll sort the chars to get the minimum
         *  and make a result string according to the start indexes
         **/
        HashMap<Integer, List<Integer>> components = new HashMap<>();
        
        /** merge two nodes, if they have the same root, count will not decrement
          * if we have only one root, then it means that the chars are all connected
          * thus, we can sort the whole string directly
         **/
        for(List<Integer> pair : pairs){
            dsu.union(pair.get(0), pair.get(1));
            if(dsu.getCount() == 1){
                char[] charArr = s.toCharArray();
                Arrays.sort(charArr);
                //System.out.println(charArr);
                return new String(charArr);
            }
        }
        
        /** update the root for each char in case that some of them have not been visited after the initial check
          * add the char to its root in the dict accordingly 
          * thus, we'll get all the components formed in this relationship
          * then, we'll sort the components respectively
         **/
        for(int i=0; i<s.length(); i++){
            int root = dsu.find(i);
            components.putIfAbsent(root, new ArrayList<Integer>());
            components.get(root).add(i);
        }
        
        char[] answer = new char[s.length()];
        
        for(List<Integer> node: components.values()){
            List<Integer> index = new ArrayList<Integer>();
            List<Character> chars = new ArrayList<Character>();
            
            for(int i: node){
                index.add(i);
                chars.add(s.charAt(i));
            }
            
            /** sort the chars, and fill it to the index
              * index list is intact, which indicates the location of each char to be filled in
             **/
            
            Collections.sort(chars);
            
            for(int i=0; i<chars.size(); i++){
                int group = index.get(i);
                answer[index.get(i)] = chars.get(i);
            }
        }
        
        return new String(answer);
        
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