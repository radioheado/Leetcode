class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int apples = 0, ans = 0;
        for (int a: apple) {
            apples += a;
        }

        for (int i = capacity.length - 1; i >= 0; i--) {
            apples -= capacity[i];
            ans++;
            if (apples <= 0) {
                break;
            }
        }

        return ans;
    }
}