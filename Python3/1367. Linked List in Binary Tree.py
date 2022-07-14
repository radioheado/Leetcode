# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubPath(self, head: Optional[ListNode], root: Optional[TreeNode]) -> bool:
        
        def dfs(node = root, ll = head):
            if not ll:
                return True
            if not node:
                return False
            
            if node.val == ll.val:
                return dfs(node.left, ll.next) or dfs(node.right, ll.next)
            return False
                
        def helper(node = root):
            if not node:
                return False
            
            if node.val == head.val: 
                if dfs(node, head):
                    return True
            
            return helper(node.left) or helper(node.right)
        
        return helper()