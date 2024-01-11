class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int ans = -1;

        for (int i = 0; i < s.length(); i++) {
            int p = s.charAt(i) - 'a';
            if (pos[p] == -1) {
                pos[p] = i;
            } else {
                ans = Math.max(ans, i - pos[p] - 1);
            }
        }

        return ans;
    }
}