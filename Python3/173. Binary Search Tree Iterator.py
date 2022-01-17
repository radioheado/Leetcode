# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.nums = deque()
        
        def dfs(node):
            if not node:
                return 
            
            if node.left:
                dfs(node.left)
                
            self.nums.append(node.val)
            
            if node.right:
                dfs(node.right)
                
        dfs(root)
            

    def next(self) -> int:
        return self.nums.popleft()

    def hasNext(self) -> bool:
        return True if len(self.nums) > 0 else False


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()