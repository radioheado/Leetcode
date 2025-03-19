class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0, white = 0, ans = k;

        for (int r = 0; r < blocks.length(); r++) {
            char c = blocks.charAt(r);
            if (c == 'W') {
                white++;
            }

            if (r - l + 1 == k) {
                ans = Math.min(ans, white);
                white -= blocks.charAt(l) == 'W' ? 1 : 0;
                l++;
            }
        }
        
        return ans;
    }
}