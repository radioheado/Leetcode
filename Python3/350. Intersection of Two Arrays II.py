class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ints1 = collections.Counter(nums1)
        ints2 = collections.Counter(nums2)
        
        ans = []
        for num, cnts in ints1.items():
            
            # this is an intersection, calculate the minimal counts
            if num in ints2:
                for i in range(min(cnts, ints2[num])):
                    ans.append(num)
                
        return ans