class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ref = {}
        stack = deque()
        
        for n in nums2:
            # case 1: found the next greater element
            while stack and n > stack[-1]:
                ref[stack.pop()] = n
                
            # case 2: the stack is empty
            # case 3: descending slope
            stack.append(n)
            
        for i, n in enumerate(nums1):
            nums1[i] = ref.get(n, -1)
                
        return nums1            
            
                