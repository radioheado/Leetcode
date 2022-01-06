class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        
        # use Bucket Sort
        bucket = [0] * 1001
        
        for t in trips:
            # add the number of passengers to the from time
            # and minus the number of passengers to the end time
            bucket[t[1]] += t[0]
            bucket[t[2]] -= t[0]
            
        total = 0
        
        # traverse the buckets to see if there is a timestamp that has passengers 
        # more than the capacity
        for b in bucket:
            total += b
            if total > capacity:
                return False
            
        return True