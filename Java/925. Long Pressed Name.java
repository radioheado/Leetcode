class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = 0, t = 0, N = name.length(), T = typed.length();

        while (n < N && t < T) {
            int count = 0;
            char c = name.charAt(n);

            while (n < N && name.charAt(n) == c) {
                count++;
                n++;
            }
            while (t < T && typed.charAt(t) == c) {
                count--;
                t++;
            }

            if (count > 0) {
                return false;
            }
        }

        return n == N && t == T;
    }
}