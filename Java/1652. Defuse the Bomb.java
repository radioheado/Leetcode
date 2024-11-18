class Solution {
    public int[] decrypt(int[] code, int k) {
        int N = code.length;
        int[] ans = new int[N];
        // Case 3
        if (k == 0) {
            return ans;
        }

        int s = 1, e = k, window = 0;
        if (k < 0) {
            s = N - Math.abs(k);
            e = N - 1;
        }

        for (int i = s; i <= e; i++) {
            window += code[i];
        }

        for (int i = 0; i < N; i++) {
            ans[i] = window;
            window -= code[s++ % N];
            window += code[(e++ + 1) % N];
        }
        
        return ans;
    }
}