# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = []
        ans = []
        
        while root or stack:
            # while root has left child, push it to the stack
            # when it stops, we reach the leftmost node of root
            # then we start popping from the end
            # add the popped value, and start pushing its right child
            while root:
                stack.append(root)
                root = root.left
                
            # start popping
            root = stack.pop()
            # add its value
            ans.append(root.val)
            # start visiting its right child
            # if right child has left subtree
            # we'll visit it in the next while loop
            root = root.right
            
        return ans
        