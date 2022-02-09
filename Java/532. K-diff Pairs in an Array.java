class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        int ans = 0;
        for(Integer n: map.keySet()){
            if(k > 0 && map.containsKey(n+k)){
                ans++;
            }
            
            if(k == 0 && map.get(n) > 1){
                ans++;
            }
        }
        
        return ans;
    }
}