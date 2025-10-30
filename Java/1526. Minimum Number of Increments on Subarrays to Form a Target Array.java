class Solution {
    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for (int i = 0; i < target.length - 1; i++) {
            ans += Math.max(0, target[i + 1] - target[i]);
        }
        return ans;
    }
}