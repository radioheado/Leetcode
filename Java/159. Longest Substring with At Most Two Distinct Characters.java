class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int distinct = 0, l = 0, ans = 0;
        Map<Character, Integer> chars = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (chars.getOrDefault(c, 0) == 0) {
                distinct++;
                while (l < r && distinct > 2) {
                    chars.put(s.charAt(l), chars.get(s.charAt(l)) - 1);
                    if (chars.get(s.charAt(l)) == 0) {
                        distinct--;
                    }
                    l++;
                }
            } 
            chars.put(c, chars.getOrDefault(c, 0) + 1);
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}