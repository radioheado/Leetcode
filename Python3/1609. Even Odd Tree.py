# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        
        def checkOdd(queue) -> bool:
            size = len(queue)
            pre = 10 ** 6 + 1
            for _ in range(size):
                node = queue.popleft()
                # odd level num must be even and decreasing
                if node.val % 2 or node.val >= pre:
                    return False
                pre = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            return True

        def checkEven(queue) -> bool:
            size = len(queue)
            pre = 0
            for _ in range(size):
                node = queue.popleft()
                # even level num must be odd and increasing
                if node.val % 2 == 0 or node.val <= pre:
                    return False
                pre = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            return True

        level = 0
        q = deque([root])

        while q:
            # odd level
            if level % 2:
                if not checkOdd(q):
                    return False
            else:
                if not checkEven(q):
                    return False
            level += 1

        return True