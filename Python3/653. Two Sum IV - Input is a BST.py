# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        
        nums = []
        def inorder(node = root):
            if not node:
                return
            
            inorder(node.left)
            nums.append(node.val)
            inorder(node.right)
            
        inorder()
        left, right = 0, len(nums)-1
        
        while left < right:
            if nums[left] + nums[right] > k:
                right -= 1
            elif nums[left] + nums[right] < k:
                left += 1
            else:
                return True
            
        return False
                
                