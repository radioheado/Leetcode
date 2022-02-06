class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        ans = []
        
        def backtrack(start, cur):
            #print(start, cur)
            
            # permutation complete
            if len(cur) == len(s):
                #print(cur)
                ans.append(''.join(cur[:]))
            
            if start >= len(s):
                return
            
            # current char is letter
            if s[start].isalpha():
                cur.append(s[start].lower())
                #print(cur)
                backtrack(start+1, cur)
                cur.pop()
                cur.append(s[start].upper())
                backtrack(start+1, cur)
                cur.pop()
                
            else:
                cur.append(s[start])
                backtrack(start+1, cur)
                cur.pop()
            
                
        backtrack(0, [])
        return ans
            
            