class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int count = 0, ans = 0;
        prefix.put(0, -1);
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                count--;
            }else{
                count++;
            }
            
            if(prefix.containsKey(count)){
                ans = Math.max(ans, i - prefix.get(count));
            }else{
                prefix.put(count, i);
            }
        }
        
        return ans;
    }
}