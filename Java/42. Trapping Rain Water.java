class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length-1, lmax = 0, rmax = 0, ans = 0;
        
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] < lmax) {
                    ans += lmax - height[l++];
                } else {
                    lmax = height[l++];
                }
            } else {
                if (height[r] < rmax) {
                    ans += rmax - height[r--];
                } else {
                    rmax = height[r--];
                }
            }
        }
        
        return ans;
    }
}