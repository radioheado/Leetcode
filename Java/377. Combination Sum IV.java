class Solution {
    private Map<Integer, Integer> memo;
    
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap();
        return helper(nums, target);
    }
    
    private int helper(int[] nums, int remain) {
        if (remain == 0) {
            return 1;
        }
        
        if (memo.containsKey(remain)) {
            return memo.get(remain);
        }
        
        int res = 0;
        for (int n: nums) {
            if (remain - n >= 0) {
                res += helper(nums, remain - n);
            } else {
                break;
            }
        }
        
        memo.put(remain, res);
        return res;
    }
}