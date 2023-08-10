class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums)-1
        
        def existsInFirstHalf(s: int, n: int) -> bool:
            return nums[s] <= n

        # if target == the left element
        # then target can be in the first half or the second half
        # hence, binary search is not helpful in this case
        def binarySearchable(s: int, n: int) -> bool:
            return nums[s] != n

        while left <= right:
            mid = (right-left)//2 + left
            
            # found the target
            if nums[mid] == target:
                return True
            
            # cannot reduce the search space to half
            if not binarySearchable(left, nums[mid]):
                left += 1
                continue

            pivot = existsInFirstHalf(left, nums[mid])
            half = existsInFirstHalf(left, target)

            # the mid and target are in different halves
            if pivot ^ half:
                # mid in the first half, target in the second half
                if pivot:
                    left = mid + 1
                # target in the first half, mid in the second half
                else:
                    right = mid - 1

            # the mid and target are in the same half
            else:
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
                    
        return False