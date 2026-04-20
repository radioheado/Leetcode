class Solution {
    public int maxDistance(int[] colors) {
        int left = 0, right = colors.length - 1, ans = 0;

        while (left < right) {
            if (colors[left] != colors[right]) {
                ans = Math.max(ans, right - left);
                break;
            }
            right--;
        }

        left = 0;
        right = colors.length - 1;
        while (left < right) {
            if (colors[left] != colors[right]) {
                ans = Math.max(ans, right - left);
                break;
            }
            left++;
        }

        return ans;
    }
}