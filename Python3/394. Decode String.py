# use a stack to push each char from the start
# stop pushing if encountering a ']'
# start popping from the top and save them to temp
# until reaching a '[', then continue popping until getting a digit
# perform multiplying to temp with the digit
# and push the result string back to the stack
# continue pushing and popping using the same logic
# so we'll get correct answer for the cases like 3[a2[bc]]
# where braces are inside braces

class Solution:
    def decodeString(self, s: str) -> str:
        # use two stacks, one saves integers
        # the other one saves chars
        times = deque()
        
        # use number to save the multiplying integer
        # since we are keeping track of the number orderly
        # the formula is simply: number = number*10 + current_digit
        # reset the value when encountering '['
        number = 0
        chars = deque()
        answer = ''
        
        for c in s:
            
            # if encounter a digit, cumulatively calculate it
            if c.isdigit():
                #print(number, c)
                number = number*10 + int(c)
            
            # if encounter '[', we have to reset number and base
            # as well as pushing number into times stack if it's not 0
            elif c == '[':
                chars.append(c)
                if number:
                    times.append(number)
                number = 0
                #print(times[-1])   
                
            # if encounter ']', we need to decode
            elif c == ']':
                temp = ''
                while chars[-1] != '[':
                    # add the top element to the beginning of the temp string
                    # because it's reversed
                    temp = chars.pop()+temp
                
                # current peek is '[', simply pop it
                chars.pop()
                
                # multiply the temp string with times
                temp *= times.pop()
                
                # now we get the inner temp string
                # push them back to the chars stack
                for t in temp:
                    chars.append(t)
            # push characters into chars stack        
            else:
                chars.append(c)
            
            
                   
        # push the results in stack to answer
        while chars:
            answer = chars.pop()+answer
            
        return answer
                
                
                    
        
        