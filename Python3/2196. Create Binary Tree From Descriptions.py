# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        nodes = {}
        parents = set()
        children = set()

        for p, c, d in descriptions:
            parent = nodes.setdefault(p, TreeNode(p))
            child = nodes.setdefault(c, TreeNode(c))
            if d == 1:
                parent.left = child
            else:
                parent.right = child

            parents.add(p)
            children.add(c)

        return nodes[list(parents - children)[0]]