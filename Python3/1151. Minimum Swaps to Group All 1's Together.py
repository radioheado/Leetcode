class Solution:
    def minSwaps(self, data: List[int]) -> int:
        ones = data.count(1)
        smallest = ones
        cur_one = 0
         
        for i, n in enumerate(data):
            cur_one += n
            
            # slide the window
            if i >= ones:
                cur_one -= data[i-ones]
                smallest = min(smallest, ones-cur_one)
            elif i == ones - 1:
                smallest = min(smallest, ones-cur_one)
                
            #print("cur one = %d, smallest = %d" %(cur_one, smallest))
            
        return smallest
            