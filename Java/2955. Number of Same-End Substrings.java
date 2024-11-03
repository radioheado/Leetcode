class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int N = s.length();
        int[] ans = new int[queries.length];
        int[][] chars = new int[26][N];

        for (int i = 0; i < N; i++) {
            chars[s.charAt(i) - 'a'][i]++;
        }

        for (int[] freq: chars) {
            for (int i = 1; i < N; i++) {
                freq[i] += freq[i - 1];
            }
        }
        
        int j = 0;
        for (int[] query: queries) {
            int s_idx = query[0], e_idx = query[1], temp = 0;
            for (int i = 0; i < 26; i++) {
                int s_freq = s_idx == 0 ? 0 : chars[i][s_idx - 1];
                int e_freq = chars[i][e_idx];
                int x = e_freq - s_freq;
                temp += (x * (x + 1)) / 2;
            }
            ans[j++] = temp;
        }

        return ans;
    }
}