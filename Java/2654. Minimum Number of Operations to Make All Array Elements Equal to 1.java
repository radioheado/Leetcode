class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, g = 0, ones = 0;
        for (int num: nums) {
            if (num == 1) {
                ones++;
            }
            g = gcd(g, num);
        }

        if (ones > 0) {
            return n - ones;
        }
        if (g > 1) {
            return -1;
        }

        int minLen = n;
        for (int i = 0; i < n; i++) {
            g = 0;
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}