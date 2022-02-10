class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {'2':'abc', '3':'def', '4':'ghi', '5':'jkl', '6':'mno', '7':'pqrs', '8':'tuv', '9':'wxyz'}
        for m in mapping:
            tmp = []
            for i in mapping[m]:
                tmp.append(i)
            mapping[m] = tmp
        #print(mapping)
        
        def backtrack(com, nex):
            if not nex:    
                output.append(com)
                
            else:
                for letter in mapping[nex[0]]:
                    backtrack(com+letter, nex[1:])
        
        output = []
        if digits:
            backtrack('', digits)
        return output
            
        