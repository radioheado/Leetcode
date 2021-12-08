class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        
        return dfs(nums, 0, target, new HashMap<>());
    }
    
    private int dfs(int[] nums, int i, int sum, Map<String, Integer> memo){
        String temp = i+"->"+sum;
        // System.out.println(temp);
        
        if(memo.containsKey(temp)){
            // System.out.println(temp + "\t" + memo.get(temp));
            return memo.get(temp);
            
        }
        
        if(i == nums.length){
            return sum == 0 ? 1 : 0;
        }
        
        int count = 0;
        count += dfs(nums, i+1, sum-nums[i], memo);
        count += dfs(nums, i+1, sum+nums[i], memo);
        memo.put(temp, count);
        return count;
    }
}