# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        graph = defaultdict(list)
        leaves = set()

        def dfs(node, parent):
            if not node:
                return

            if not node.left and not node.right:
                leaves.add(node)
            
            if parent:
                graph[parent].append(node)
                graph[node].append(parent)

            dfs(node.left, node)
            dfs(node.right, node)

        dfs(root, None)
        ans = 0
        for leaf in leaves:
            queue = deque()
            visited = set()
            queue.append(leaf)
            for _ in range(distance + 1):
                size = len(queue)
                for j in range(size):
                    node = queue.popleft()
                    if node in leaves and node != leaf:
                        ans += 1
                    for neighbor in graph[node]:
                        if neighbor not in visited:
                            queue.append(neighbor)
                            visited.add(neighbor)

        return ans // 2