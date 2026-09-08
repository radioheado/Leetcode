class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0, l = 0;
        String ans = s;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count += c == '1' ? 1 : 0;
            while (count > k) {
                count -= s.charAt(l) == '1' ? 1 : 0;
                l++;
            }
            while (l < s.length() && s.charAt(l) == '0') {
                l++;
            }

            if (count == k) {
                ans = compare(ans, s.substring(l, r+1));
            }
        }
        return count >= k ? ans : new String();
    }

    private String compare(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s2;
        } else if (s1.length() < s2.length()) {
            return s1;
        } else {
            return s1.compareTo(s2) < 0 ? s1 : s2;
        }
    }
}