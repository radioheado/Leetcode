# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        ans = 0
        q = deque([(root, set())])
        
        while q:
            root, count = q.popleft()
            if root.val in count:
                new_count = count - {root.val}
            else:
                new_count = count.union({root.val})
            
            if not root.left and not root.right:
                if len(new_count) <= 1:
                    ans += 1
                continue
            
            #print(root.val, count)
            if root.left:
                q.append((root.left, new_count))
                    
            if root.right:
                q.append((root.right, new_count))
                    
        
        return ans