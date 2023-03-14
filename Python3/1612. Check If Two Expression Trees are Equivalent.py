# Definition for a binary tree node.
# class Node(object):
#     def __init__(self, val=" ", left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkEquivalence(self, root1: 'Node', root2: 'Node') -> bool:
        vals1 = [0] * 26
        vals2 = [0] * 26

        def dfs(node: 'Node', vals: List[int]) -> None:
            # leaf node
            if node.val != '+':
                vals[ord(node.val) - ord('a')] += 1
                return

            dfs(node.left, vals)
            dfs(node.right, vals)

        dfs(root1, vals1)
        dfs(root2, vals2)
        return vals1 == vals2