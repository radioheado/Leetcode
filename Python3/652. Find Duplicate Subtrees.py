# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        self.pattern = collections.defaultdict(list)
        
        def dfs(node: TreeNode) -> str:
            if not node:
                return 'None'
            
            # leaf node
            if not node.left and not node.right:
                self.pattern[node.val].append(node)
                return str(node.val)
            
            left = dfs(node.left)
            right = dfs(node.right)
            
            ptn = str(node.val) + ',' + left + ',' + right
            
            self.pattern[ptn].append(node)
            #print(ptn)
            
            return ptn
        
        dfs(root)
        ans = []
        
        for nodes in self.pattern.values():
            if len(nodes) > 1:
                ans.append(nodes[0])
                
        return ans