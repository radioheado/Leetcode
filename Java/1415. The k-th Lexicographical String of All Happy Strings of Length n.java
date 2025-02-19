class Solution {
    public String getHappyString(int n, int k) {
        int midpoint = 1 << (n - 1);
        if (3 * midpoint < k) {
            return "";
        }

        Map<Character, Character> nextSmallest = new HashMap<>();
        nextSmallest.put('a', 'b');
        nextSmallest.put('b', 'a');
        nextSmallest.put('c', 'a');

        Map<Character, Character> nextGreatest = new HashMap<>();
        nextGreatest.put('a', 'c');
        nextGreatest.put('b', 'c');
        nextGreatest.put('c', 'b');

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append('a');
        }

        int start_a = 1, start_b = start_a + midpoint, start_c = start_b + midpoint;
        if (k < start_b) {
            k -= start_a;
        } else if (k < start_c) {
            ans.setCharAt(0, 'b');
            k -= start_b;
        } else {
            ans.setCharAt(0, 'c');
            k -= start_c;
        }

        for (int i = 1; i < n; i++) {
            midpoint /= 2;
            if (k < midpoint) {
                ans.setCharAt(i, nextSmallest.get(ans.charAt(i - 1)));
            } else {
                ans.setCharAt(i, nextGreatest.get(ans.charAt(i - 1)));
                k -= midpoint;
            }
        }

        return ans.toString();
    }
}