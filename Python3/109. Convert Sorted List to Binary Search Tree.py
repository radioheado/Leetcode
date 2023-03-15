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
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        if not head:
            return None

        # return mid
        def findMid(root: Optional[ListNode]) -> Optional[ListNode]:
            prev = None
            mid = fast = root
            while fast and fast.next:
                prev = mid
                mid = mid.next
                fast = fast.next.next

            if prev:
                prev.next = None
            
            return mid

        def helper(root: Optional[ListNode]) -> Optional[TreeNode]:
            if not root:
                return None
                
            mid = findMid(root)
            new_root = TreeNode(mid.val)

            # only one node left
            if root == mid:
                return new_root

            new_root.left = helper(root)
            new_root.right = helper(mid.next)
            return new_root

        return helper(head)

