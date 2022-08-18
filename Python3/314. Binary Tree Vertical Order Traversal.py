# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        
        # use a queue to do bfs
        # add column number to the node
        # so it's easy to add the node's value to the correct vertical position
        q = deque([(root, 0)])
        
        # use this dict to keep track of the information:
        # column: [node.val]
        columns = collections.defaultdict(list)
        
        # use two integers to indicate the columns we need to enumerate
        # out from the columns dict
        minCol, maxCol = 0, 0
        
        while q:
            root, col = q.popleft()
            columns[col].append(root.val)
            if root.left:
                q.append((root.left, col-1))
                minCol = min(minCol, col-1)
            if root.right:
                q.append((root.right, col+1))
                maxCol = max(maxCol, col+1)
        
        answer = []
        
        for col in range(minCol, maxCol+1):
            answer.append(columns[col])
            
        return answer
            
            
        