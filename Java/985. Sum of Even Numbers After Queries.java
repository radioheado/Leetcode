class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int even_sum = 0;
        for (int n: nums) {
            even_sum += even(n) ? n : 0;
        }
        
        int cur, after, val, i;
        int[] ans = new int[queries.length];
        
        for (int j=0; j<queries.length; j++) {
            val = queries[j][0];
            i = queries[j][1];
            
            cur = nums[i];
            after = cur + val;
            nums[i] = after;
            
            if (odd(cur) && even(after)) {
                even_sum += after;
            } else if (even(cur) && odd(after)) {
                even_sum -= cur;
            } else if (even(cur) && even(after)) {
                even_sum += val;
            }
            
            ans[j] = even_sum;
        }
        
        return ans;
    }
    
    private boolean odd(int n) {
        return Math.abs(n) % 2 == 1;
    }
    
    private boolean even(int n) {
        return Math.abs(n) % 2 == 0;
    }
}