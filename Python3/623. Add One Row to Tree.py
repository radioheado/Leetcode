# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        # special case
        if depth == 1:
            new = TreeNode(val)
            new.left = root
            return new
        
        # tuple: (cur, cur_level)
        q = deque([(root, 1)])
        
        while q:
            cur, level = q.popleft()
            if level == depth - 1:
                new_left = TreeNode(val)
                new_right = TreeNode(val)
                new_left.left = cur.left
                new_right.right = cur.right
                cur.left = new_left
                cur.right = new_right
                continue
                
            if cur.left:
                q.append((cur.left, level + 1))
            
            if cur.right:
                q.append((cur.right, level + 1))
                
        return root