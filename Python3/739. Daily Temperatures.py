class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        ans = [0]*len(temperatures)
        # use a stack to store the decending days index
        stack = []
        stack.append(0)
        cur = 1
        
        while cur < len(temperatures):
            top = stack[-1]
            #print("cur = %d, top = %d" %(cur, top))
            while temperatures[cur] > temperatures[top]:
                #print("inner cur = %d, top = %d" %(cur, top))
                ans[top] = cur-top
                stack.pop()
                if len(stack):
                    top = stack[-1]
                else:
                    break
                
            stack.append(cur)
            cur += 1
        
        
        return ans
                