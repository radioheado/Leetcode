class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        temp = ''
        ans = 0
        for c in s:
            #print("c: " + c)
            if c not in temp:
                temp += c
            else:
                temp = temp.split(c)[1] + c
            
            ans = max(len(temp), ans)
                  
        return ans