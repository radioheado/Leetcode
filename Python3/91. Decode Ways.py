class Solution:
    def numDecodings(self, s: str) -> int:
        # special case: no way to decode any string that starts with '0'
        if s[0] == '0':
            return 0
        
        A = ord('A')
        mapping = {}
        
        for i in range(1, 27):
            mapping[str(i)] = chr(A+i-1)
        #print(mapping)
        avoid, using = 1, 1
        prev = s[0]
        
        for c in s[1:]:
            #print(prev+c)
            # if prev+c combined is not in mapping, and
            # c is also not in mapping, then we cannot decode the string
            if prev+c not in mapping and c not in mapping:
                return 0
            
            # if c is '0', we must use the prev char in this step
            # this means we have to avoid the prev char in the last step
            elif c not in mapping:
                using = avoid
            
            # if prev+c is not in mapping, we must use the prev char in the last step
            elif prev+c not in mapping:
                avoid = using
            
            # both prev+c and c are valid combinations, we can either use
            # the prev char in the last step or save it to this step
            else:
                avoid, using = using, avoid+using
            prev = c
            
        return using