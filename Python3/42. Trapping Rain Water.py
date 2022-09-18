class Solution:
    def trap(self, height: List[int]) -> int:
        left, right, ans = 0, len(height)-1, 0
        lmax, rmax = 0, 0
        
        while left < right:
            if height[left] < height[right]:
                if height[left] >= lmax:
                    lmax = height[left]
                else:
                    ans += lmax-height[left]
                left += 1
            else:
                if height[right] >= rmax:
                    rmax = height[right]
                else:
                    ans += rmax-height[right]
                right -= 1
                
        return ans