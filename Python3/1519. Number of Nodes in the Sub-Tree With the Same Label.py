class Solution:
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        ans = [0] * n

        adjs = collections.defaultdict(list)
        for u, v in edges:
            adjs[u].append(v)
            adjs[v].append(u)

        def dfs(node = 0, parent = -1):
            nodeCount = [0] * 26
            idx = ord(labels[node]) - ord('a')
            nodeCount[idx] = 1

            if node not in adjs:
                return nodeCount
            
            for child in adjs[node]:
                if child == parent:
                    continue

                childCount = dfs(child, node)
                for i in range(26):
                    nodeCount[i] += childCount[i]

            ans[node] = nodeCount[idx]
            return nodeCount

        dfs()
        return ans