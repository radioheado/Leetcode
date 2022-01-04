# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        
        self.cache = {}
        
        def construct(start, end):
            if start > end:
                return [None]
            
            if (start, end) in self.cache:
                return self.cache[(start, end)]
            
            trees = []
            
            for i in range(start, end+1):
                left = construct(start, i-1)
                right = construct(i+1, end)
                
                for l in left:
                    for r in right:
                        cur = TreeNode(i)
                        cur.left = l
                        cur.right = r
                        trees.append(cur)
                        
            self.cache[(start, end)] = trees
            return trees
        
        return construct(1, n) if n else []