# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        
        nums1 = self.traverse(root1, [])
        nums2 = self.traverse(root2, [])
        
        # edge cases
        if not nums1:
            return nums2
        if not nums2:
            return nums1
        
        res = []
        
        i, j = 0, 0
        while i < len(nums1) and j < len(nums2):
            num1 = nums1[i] 
            num2 = nums2[j] 
            
            if num1 <= num2:
                res.append(num1)
                i += 1
            else:
                res.append(num2)
                j += 1
        
        # add all the remaining numbers
        res.extend(nums1[i:])
        res.extend(nums2[j:])
        
        return res
    
    # inorderly traverse the BST 
    def traverse(self, root: TreeNode, nums: List[int]) -> List[int]:
        if not root:
            return 
        
        self.traverse(root.left, nums)
        nums.append(root.val)
        self.traverse(root.right, nums)
        
        return nums
         
        