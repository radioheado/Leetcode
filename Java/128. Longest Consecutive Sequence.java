class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> vals = new HashSet<>();
        for (int n: nums) {
            vals.add(n);
        }
        
        int ans = 0, count, cur;
        for (int n: vals) {
            if (!vals.contains(n-1)) {
                cur = n;
                count = 1;
                
                while (vals.contains(n+1)) {
                    count++;
                    n++;
                }
                
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
}