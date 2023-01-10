class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;

        for (int c: costs) {
            if (c <= coins) {
                coins -= c;
                bars++;
            } else {
                break;
            }
        }

        return bars;
    }
}