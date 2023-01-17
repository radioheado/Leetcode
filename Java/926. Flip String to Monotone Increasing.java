class Solution {
    public int minFlipsMonoIncr(String s) {
        int flip = 0;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                flip++;
            }
        }

        int ans = flip;
        for (char c: s.toCharArray()) {
            if (c == '0') {
                flip--;
                ans = Math.min(ans, flip);
            } else {
                flip++;
            }
        }

        return ans;
    }
}