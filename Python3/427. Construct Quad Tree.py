"""
# Definition for a QuadTree node.
class Node:
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""

class Solution:
    def construct(self, grid: List[List[int]]) -> 'Node':

        def helper(x: int, y: int, size: int) -> 'Node':
            if size == 1:
                return Node(grid[x][y], True)

            s = size // 2
            topLeft = helper(x, y, s)
            topRight = helper(x, y + s, s)
            bottomLeft = helper(x + s, y, s)
            bottomRight = helper(x + s, y + s, s)

            if topLeft.isLeaf and topRight.isLeaf and bottomLeft.isLeaf and bottomRight.isLeaf \
            and topLeft.val == topRight.val \
            and topRight.val == bottomLeft.val \
            and bottomLeft.val == bottomRight.val:
                return Node(topLeft.val, True)

            return Node(False, False, topLeft, topRight, bottomLeft, bottomRight)

        return helper(0, 0, len(grid))