class Solution {
    public int[] minOperations(String boxes) {
        int N = boxes.length();
        int[] ans = new int[N];
        int left_count = 0, left_prefix = 0, 
            right_count = 0, right_prefix = 0;

        for (int i = 0; i < N; i++) {
            ans[i] += left_prefix;
            left_count += boxes.charAt(i) == '1' ? 1 : 0;
            left_prefix += left_count;

            int j = N - i - 1;
            ans[j] += right_prefix;
            right_count += boxes.charAt(j) == '1' ? 1 : 0;
            right_prefix += right_count;
        }

        return ans;
    }
}