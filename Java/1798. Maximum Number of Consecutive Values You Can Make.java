class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int cur = 0;
        for (int n: coins) {
            if (n <= cur+1) {
                cur += n;
            }
        }
        
        return cur+1;
    }
}