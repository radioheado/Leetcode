class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # count how many times a character appears in t
        count = Counter(t)
        
        # the total characters appear in t
        required = len(count)
        
        # count how many times a required character appears in s
        window = {}
        
        # keep track of how many required characters satisfy the value in count
        satisfied = 0
        
        # left and right pointers
        left = right = 0
        
        # answer tuple using the form: (length, left, right)
        ans = float('inf'), None, None
        
        while right < len(s):
            
            # if this is a required character
            if s[right] in count:
                window[s[right]] = window.get(s[right], 0)+1
                if window.get(s[right]) == count.get(s[right]):
                    satisfied += 1
                    
            while left<=right and satisfied==required:
                if right-left+1 < ans[0]:
                    ans = (right-left+1, left, right)
                
                # the start of the current window needs to be deducted from window dict
                
                if s[left] in window:
                    window[s[left]] -= 1
                    if window.get(s[left]) < count.get(s[left]):
                        satisfied -= 1
                    
                left += 1
                
            right += 1
            
        return "" if ans[0] == float("inf") else s[ans[1]:ans[2]+1]
                
        