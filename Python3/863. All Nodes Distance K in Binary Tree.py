# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:

        def dfs(node = root, par = None):
            if node:
                node.par = par
                dfs(node.left, node)
                dfs(node.right, node)

        dfs()
        q = deque([(target, 0)])
        visited = {target}

        while q:
            if q[0][1] == k:
                return [node.val for node, d in q]

            node, d = q.popleft()
            for nei in [node.left, node.right, node.par]:
                if nei and nei not in visited:
                    visited.add(nei)
                    q.append((nei, d + 1))

        return []