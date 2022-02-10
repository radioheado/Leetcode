class Solution {
    private List<List<Integer>> ans;
    private static int n;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        n = nums.length;
        Map<Integer, Integer> counter = new HashMap<>();
        
        for(int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }
        
        backtrack(new ArrayList<Integer>(), counter);
        return ans;
    }
    
    private void backtrack(List<Integer> cur, Map<Integer, Integer> counter) {
        // make a deep copy
        if(cur.size() == n) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(Integer num: counter.keySet()){
            if(counter.get(num) > 0){
                counter.put(num, counter.get(num)-1);
                cur.add(num);
                backtrack(cur, counter);
                counter.put(num, counter.get(num)+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}