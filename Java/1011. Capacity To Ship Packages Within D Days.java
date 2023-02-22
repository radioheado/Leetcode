class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // l: maxWeight, r: totalWeight
        int l = 0, r = 0, m;
        for (int w: weights) {
            l = Math.max(l, w);
            r += w;
        }

        while (l < r) {
            m = (r - l) / 2 + l;
            if (shippable(weights, days, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private boolean shippable(int[] weights, int days, int capacity) {
        int day = 1, load = 0;
        for (int w: weights) {
            load += w;
            if (load > capacity) {
                day++;
                load = w;
            }
        }
        return day <= days;
    }
}