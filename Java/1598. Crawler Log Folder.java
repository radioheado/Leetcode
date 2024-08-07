class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String log: logs) {
            if (log.equals("./")) {
                continue;
            } else if (log.equals("../")) {
                ans = Math.max(ans - 1, 0);
            } else {
                ans++;
            }
        }
        return ans;
    }
}