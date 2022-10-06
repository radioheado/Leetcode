class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0, p = 0;
        char pre = colors.charAt(0);
        
        for (int c = 1; c < colors.length(); c++) {
            char cur = colors.charAt(c);
            if (pre == cur) {
                if (neededTime[c] < neededTime[p]) {
                    ans += neededTime[c];
                } else {
                    ans += neededTime[p];
                    p = c;
                }
            } else {
                p = c;
                pre = cur;
            }
        }
        
        return ans;
    }
}