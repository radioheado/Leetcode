class Solution:
    def isPossible(self, target: List[int]) -> bool:
        # special case:
        if len(target) == 1:
            return target[0] == 1
        
        # a max heap to keep track of current_largest_num
        heap = [-n for n in target]
        heapq.heapify(heap)
        
        SUM = sum(target)
        # push -num to the max heap
        
        # if top of the heap is -1, we reached the goal
        while heap[0] < -1:
            # turn the largest number to positive
            largest = -heapq.heappop(heap)
            rest_sum = SUM - largest
            
            # there are only two numbers in target
            if rest_sum == 1:
                return True
            
            rem = largest % rest_sum
            # if current largest number is not greater than the rest sum
            # it's impossible to make it
            if rem == 0 or rem == largest:
                return False
            
            # push the new number to the heap for further process
            # and update the sum
            heapq.heappush(heap, -rem)
            SUM = rest_sum + rem
            
        return True