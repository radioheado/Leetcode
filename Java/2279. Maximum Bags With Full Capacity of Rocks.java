class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for (int i = 0; i < rocks.length; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);
        int i = 0, ans = 0;
        while (additionalRocks > 0 && i < capacity.length) {
            if (capacity[i] <= additionalRocks) {
                additionalRocks -= capacity[i++];
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }
}