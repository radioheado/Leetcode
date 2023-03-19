# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def upsideDownBinaryTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        stack = deque()
        
        while root:
            stack.append(root)
            root = root.left

        new_root = stack[-1]
        while len(stack) > 1:
            # left child
            node = stack.pop()

            # parent node
            parent = stack[-1]

            # right child
            right = parent.right

            parent.left = None
            parent.right = None
            
            node.left = right
            node.right = parent

        return new_root