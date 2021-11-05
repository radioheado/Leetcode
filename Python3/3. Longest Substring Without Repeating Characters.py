class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans, left, right = 0, 0, 0
        char = [0]*128
        
        while right < len(s):
            
            char[ord(s[right])] += 1
            
            while char[ord(s[right])] > 1:
                char[ord(s[left])] -= 1
                left += 1
            
            ans = max(ans, right-left+1)
            right += 1
                  
        return ans