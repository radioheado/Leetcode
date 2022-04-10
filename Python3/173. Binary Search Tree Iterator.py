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


# O(1) time and O(h) solution:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        self.stack = deque()
        # add the left nodes
        while root:
            self.stack.append(root)
            root = root.left
        
    def next(self) -> int:
        # get the next leftmost node
        node = self.stack.pop()
        val = node.val
        node = node.right
        # add left nodes under node
        while node:
            self.stack.append(node)
            node = node.left
        return val

    def hasNext(self) -> bool:
        return len(self.stack) > 0


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()