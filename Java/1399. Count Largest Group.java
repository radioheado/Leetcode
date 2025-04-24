class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> sum_set = new HashMap<>();
        int max_size = 0, ans = 0;

        for (int num = 1; num <= n; num++) {
            int digit_sum = 0, cur = num;
            while (cur > 0) {
                digit_sum += cur % 10;
                cur /= 10;
            }
            sum_set.put(digit_sum, sum_set.getOrDefault(digit_sum, 0) + 1);
            max_size = Math.max(max_size, sum_set.get(digit_sum));
        }

        for (int v: sum_set.values()) {
            if (v == max_size) {
                ans++;
            }
        }
        return ans;
    }
}