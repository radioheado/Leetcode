class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        int total = 0;
        int count = 0;
        
        for(int n: nums){
            total += n;
            if(total == k){
                count++;
            }
            
            if(sums.containsKey(total-k)){
                count += sums.get(total-k);
            }
            
            sums.put(total, sums.getOrDefault(total, 0)+1);
        }
        
        return count;
        
    }
}