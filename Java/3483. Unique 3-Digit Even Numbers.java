class Solution {
    public int totalNumbers(int[] digits) {
        int ans = 0, n = digits.length;
        boolean[] seen = new boolean[1000];

        for (int i = 0; i < n; i++) {
            int n1 = digits[i];
            if (n1 == 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                int n2 = digits[j];
                for (int k = 0; k < n; k++) {
                    int n3 = digits[k];
                    if (k == i || k == j || n3 % 2 == 1) {
                        continue;
                    }
                    int num = n1 * 100 + n2 * 10 + n3;
                    if (!seen[num]) {
                        seen[num] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}