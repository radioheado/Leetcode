class Solution {
    public int shortestWay(String source, String target) {
        Set<Character> chars = new HashSet();
        for (char c: source.toCharArray()) {
            chars.add(c);
        }

        int s = 0, t = 0, ans = 0, S = source.length(), T = target.length();
        while (t < T) {
            if (!chars.contains(target.charAt(t))) {
                return -1;
            }

            if (source.charAt(s) == target.charAt(t)) {
                t++;
            }
            s++;

            if (s == S || t == T) {
                ans++;
                s = 0;
            }
        }

        return ans;
    }
}