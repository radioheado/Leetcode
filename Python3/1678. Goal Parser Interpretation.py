class Solution:
    def interpret(self, command: str) -> str:
        ans = ''
        i = 0
        
        while i < len(command):
            if command[i] == 'G':
                ans += 'G'
            elif command[i] == '(':
                if command[i+1] == ')':
                    ans += 'o'
                    # increment an extra step
                    i += 1
                else:
                    ans += 'al'
                    # increment extra three steps
                    i += 3
            i += 1
            
        return ans
                    