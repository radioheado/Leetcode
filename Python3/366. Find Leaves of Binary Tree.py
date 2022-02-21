# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans = []
        
        def getLevel(root) -> int:
            if not root:
                return -1

            left = getLevel(root.left)
            right = getLevel(root.right)
            cur = max(left, right)+1
            
            # new level reached
            if len(ans) == cur:
                ans.append([])
            
            # add current node to the corresponding array
            ans[cur].append(root.val)
            
            return cur
        
        getLevel(root)
        return ans
        