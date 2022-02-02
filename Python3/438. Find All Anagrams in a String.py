class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(p) > len(s):
            return []
        
        chars1 = collections.Counter(p)
                    
        ans = []
        left = right = 0
        chars2 = collections.defaultdict(int)
        
        while right < len(s):
            c = s[right]
            right += 1
            
            # refresh the dict
            if c not in chars1:
                chars2.clear()
                left = right
            
            else:
                chars2[c] += 1
                # check if need to update answer first
                if chars1 == chars2:
                    ans.append(left)
                while chars2[c] > chars1[c]:
                    chars2[s[left]] -= 1
                    left += 1
                    if chars1 == chars2:
                        ans.append(left)
                #print(chars2) 
        
        return ans
                
            