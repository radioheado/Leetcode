class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> cumu_sum = new HashMap<>();
        cumu_sum.put(0, -1);
        int res = 0, sub_sum = 0;
        
        for(int i=0; i<nums.length; i++){
            sub_sum += nums[i];
            int comp = sub_sum - k;
            
            if(cumu_sum.containsKey(comp)){
                res = Math.max(res, i-cumu_sum.get(comp));
            }
            
            if(!cumu_sum.containsKey(sub_sum)){
                cumu_sum.put(sub_sum, i);
            }
        }
        
        return res;
    }
}