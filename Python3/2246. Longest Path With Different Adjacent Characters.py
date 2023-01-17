class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        children = collections.defaultdict(list)
        for i, n in enumerate(parent[1:], 1):
            children[n].append(i)

        ans = 1

        def dfs(node = 0):
            if node not in children or len(children[node]) == 0:
                return 1

            longest = second = 0
            for child in children[node]:
                childPath = dfs(child)
                # don't count child if it's equal to the current node
                if s[child] == s[node]:
                    continue

                
                if childPath > longest:
                    second = longest
                    longest = childPath

                elif childPath > second:
                    second = childPath

            nonlocal ans
            ans = max(ans, longest + second + 1)  
            return longest + 1

        dfs()  
        return ans