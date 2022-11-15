# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        # get tree's height
        h = 0
        node = root
        while node.left:
            h += 1
            node = node.left
            
        # only one node
        if h == 0:
            return 1
        
        l, r = 0, 2**h - 1
        while l <= r:
            mid = l + (r - l) // 2
            if self.exists(mid, h, root):
                l = mid + 1
            else:
                r = mid - 1
                
        return 2**h - 1 + l
            
        
    def exists(self, idx: int, h: int, node: TreeNode) -> bool:
        l, r = 0, 2**h - 1
        
        for _ in range(h):
            mid = l + (r - l) // 2
            if idx <= mid:
                node = node.left
                r = mid
            else:
                node = node.right
                l = mid + 1
                
        return node is not None