class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int p = potions.length;

        int i = 0, max = potions[p-1];
        int[] ans = new int[spells.length];
        for (int s: spells) {
            long min = (long) Math.ceil((1.0 * success) / s);
            if (min > max) {
                ans[i++] = 0;
                continue;
            }
            ans[i++] = p - find(potions, (int)min);
        }

        return ans;
    }

    private int find(int[] potions, int s) {
        int l = 0, r = potions.length, m;
        while (l < r) {
            m = (r - l) / 2 + l;
            if (potions[m] < s) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}