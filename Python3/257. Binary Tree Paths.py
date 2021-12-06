# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Recursive Solution
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        self.answer = []
        
        def dfs(node, path):
            if not node:
                return 
            
            if path:
                path += "->"+str(node.val)
            else:
                path = str(node.val)
            
            # leaf node, add it to answer list
            if not node.left and not node.right:
                self.answer.append(path)
            
            dfs(node.left, path)
            dfs(node.right, path)
            
        dfs(root, "")
        return self.answer

# Iterative Solution
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        stack = deque([(root, str(root.val))])
        answer = []
        
        while stack:
            root, path = stack.pop()
            
            # leaf node, add its path to answer list
            if not root.left and not root.right:
                answer.append(path)
                
            if root.right:
                stack.append((root.right, path+'->'+str(root.right.val)))
                
            if root.left:
                stack.append((root.left, path+'->'+str(root.left.val)))
                
        return answer
            