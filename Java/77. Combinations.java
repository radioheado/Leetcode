class Solution {
    
    List<List<Integer>> answer = new LinkedList(); 
    int n;
    int k;
    
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return answer;
        
    }
    
    private void backtrack(int start, LinkedList<Integer> cur) {
            if(cur.size() < k){
                for(int i=start; i<n+1; i++){
                    cur.add(i);
                    backtrack(i+1, cur);
                    cur.removeLast();
                }
            }
            
            if(cur.size() == k){
                answer.add(new LinkedList(cur));
            }
        }
}
