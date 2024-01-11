# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        if not root:
            return 0

        graph = defaultdict(list)
        q = deque([root])

        while q:
            node = q.popleft()
            if node.left:
                graph[node.val].append(node.left.val)
                graph[node.left.val].append(node.val)
                q.append(node.left)
            
            if node.right:
                graph[node.val].append(node.right.val)
                graph[node.right.val].append(node.val)
                q.append(node.right)

        q.append(start)
        minutes = -1
        visited = set([start])

        while q:
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                for child in graph[node]:
                    if child not in visited:
                        q.append(child)
                        visited.add(child)

            minutes += 1

        return minutes
