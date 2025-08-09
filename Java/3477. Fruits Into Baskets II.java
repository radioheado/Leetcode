class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        for (int f: fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (f <= baskets[i]) {
                    ans--;
                    baskets[i] = 0;
                    break;
                }
            }
            ans++;
        }
        return ans;
    }
}