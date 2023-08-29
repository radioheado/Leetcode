class Solution {
    public int bestClosingTime(String customers) {
        int cur = 0, min = 0, ans = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                cur--;
            } else {
                cur++;
            }

            if (cur < min) {
                ans = i + 1;
                min = cur;
            }
        }

        return ans;
    }
}