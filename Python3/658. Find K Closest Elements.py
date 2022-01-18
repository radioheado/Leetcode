class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # get the search bounds
        # we tend to pick the left number since the description: a < b
        left, right = 0, len(arr)-k
        
        while left < right:
            mid = (right-left)//2 + left
            
            # arr[mid] is closer to x than arr[mid+k]
            # then numbers to the right of arr[mid+k] including itself
            # can never be in the answer
            # because every number from arr[mid] to arr[mid+k-1] are eligible in this step
            if x - arr[mid] > arr[mid+k] -x:
                left = mid+1
            else:
                right = mid
                
        return arr[left: left+k]