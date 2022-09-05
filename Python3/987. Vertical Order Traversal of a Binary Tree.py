# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if not root:
            return []
        
        # use a queue to do bfs
        # add column number to the node
        # so it's easy to add the node's value to the correct vertical position
        q = deque([(root, 0, 0)])
        
        # use this dict to keep track of the information:
        # column: [node.val]
        columns = []
        
        while q:
            root, row, col = q.popleft()
            columns.append((col, row, root.val))
            
            if root.left:
                q.append((root.left, row+1, col-1))
            if root.right:
                q.append((root.right, row+1, col+1))
        
        columns.sort()
        ans = OrderedDict()
        
        for col, row, val in columns:
            if col in ans:
                ans[col].append(val)
            else:
                ans[col] = [val]
            
        return ans.values()