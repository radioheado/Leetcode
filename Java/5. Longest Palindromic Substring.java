class Solution {
    public String longestPalindrome(String s) {
        int l = 0, r = 0, len1, len2, len;
        for (int i=0; i<s.length(); i++) {
            len1 = find(s, i, i);
            len2 = find(s, i, i+1);
            len  = Math.max(len1, len2);
            if (len > r-l) {
                l = i - (len-1)/2;
                r = i + len/2;
            }
        }
        return s.substring(l, r+1);
    }
    
    private int find (String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }
}