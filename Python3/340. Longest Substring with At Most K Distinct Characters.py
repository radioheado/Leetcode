class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        window = {}
        
        # left and right index that keep track of the sliding window
        left, right = 0, 0
        
        # distinct chars, total length of the current window, the max length of the windows
        dis, count, m = 0, 0, 0
        
        while right < len(s):
            if s[right] not in window or window[s[right]]==0:
                window[s[right]] = 1
                dis += 1
            else:
                window[s[right]] += 1
            count += 1
            
            while dis>k:
                window[s[left]] -= 1
                count -= 1
                m = max(m, count)
                if window[s[left]] == 0:
                    dis -= 1
                left += 1
            
            right += 1
                
        return max(m, count)
        
        
        