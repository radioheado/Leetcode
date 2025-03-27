class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = -1, count = 0;
        for (int n: nums) {
            if (count == 0) {
                dominant = n;
            }
            count += dominant == n ? 1 : -1;
        }

        count = 0;
        for (int n: nums) {
            if (n == dominant) {
                count++;
            }
        }

        int N = nums.size(), prefix = 0;
        for (int i = 0; i < N; i++) {
            if (nums.get(i) == dominant) {
                prefix++;
            }
            if ((prefix > (i + 1) / 2) && ((count - prefix) > (N - i - 1) / 2)) {
                return i;
            }
        }

        return -1;
    }
}