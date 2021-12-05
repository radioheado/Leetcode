# Definition for Node.
# class Node:
#     def __init__(self, val=0, left=None, right=None, random=None):
#         self.val = val
#         self.left = left
#         self.right = right
#         self.random = random

class Solution:
    
    def __init__(self):
        self.visited = {}
        
    def copyRandomBinaryTree(self, node: 'Node') -> 'NodeCopy':
        if not node:
            return None
        
        if node in self.visited:
            return self.visited[node]
        
        new = NodeCopy(node.val, None, None, None)
        self.visited[node] = new
        
        new.left = self.copyRandomBinaryTree(node.left)
        new.right = self.copyRandomBinaryTree(node.right)
        new.random = self.copyRandomBinaryTree(node.random)
        
        return new