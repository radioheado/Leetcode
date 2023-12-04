class Solution {
    public String largestGoodInteger(String num) {
        int start = 0, ans = -1;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != num.charAt(i-1)) {
                start = i;
            }

            if (i - start == 2) {
                start = i;
                ans = Math.max(ans, (int)num.charAt(i-1));
            }
        }

        return ans == -1 ? "" : new String(new char[]{(char)ans, (char)ans, (char)ans});
    }
}