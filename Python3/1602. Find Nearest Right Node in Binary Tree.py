# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findNearestRightNode(self, root: TreeNode, u: TreeNode) -> Optional[TreeNode]:
        if not root:
            return root

        q = deque([root])
        while q:
            target = False
            size = len(q)
            for _ in range(size):
                root = q.popleft()

                # reach to the nearest valid right node
                if target:
                    return root

                # reach to node u
                if root == u:
                    target = True

                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)

        return None
