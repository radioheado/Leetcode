class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # swap two elements in the list with O(1) space
        def swap(num, i, j):
            #print(i)
            temp = num[i]
            num[i] = num[j]
            num[j] = temp
        
        # reverse only the sublist after the index = pointer
        def reverser(num, left):
            right = len(num) - 1
            #print(left)
            while left < right:
                #print(num[left])
                #print(num[right])
                swap(num, left, right)
                left += 1
                right -= 1
                #print("left = ", left)
        
        # start reversely reading elements from nums
        cur = len(nums)-2
        
        while cur >= 0:
            if nums[cur] >= nums[cur+1]:
                cur -= 1
                continue
                
            if nums[cur] < nums[cur+1]:
                break
        
        # if no such an arrangement, reverse nums
        if cur == -1:
            #print(nums)
            reverser(nums, 0)
                
        else:
            swp = len(nums) - 1 
            while nums[swp] <= nums[cur]:
                swp -= 1
            swap(nums, swp, cur)
            reverser(nums, cur+1)
            
            