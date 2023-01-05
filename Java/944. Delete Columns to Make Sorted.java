class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;

        for (int c = 0; c < strs[0].length(); c++) {
            for (int r = 1; r < strs.length; r++) {
                if (strs[r].charAt(c) < strs[r-1].charAt(c)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}