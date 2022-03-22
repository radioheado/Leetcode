class Solution {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        for (int i=n-1; i>=0; i--) {
            int val = Math.min(26, k-i);
            ans[i] = (char)(val+'a'-1);
            k -= val;
        }
        return new String(ans);
    }
}