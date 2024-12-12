class Solution {
    public int maximumLength(String s) {
        Map<Pair<Character, Integer>, Integer> str_count = new HashMap<>();
        str_count.put(new Pair(s.charAt(0), 1), 1);
        int ans = -1, count = 1;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            for (int j = 1; j <= count; j++) {
                Pair<Character, Integer> pair = new Pair(c, j);
                str_count.put(pair, str_count.getOrDefault(pair, 0) + 1);
                if (str_count.get(pair) > 2) {
                    ans = Math.max(ans, j);
                }
            }
        }

        return ans;
    }
}