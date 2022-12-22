class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        ds = collections.defaultdict(list)

        for p, d in dislikes:
            ds[p].append(d)
            ds[d].append(p)

        # -1: not visited; 1: RED group; 0: BLUE group
        color = [-1] * (n + 1)

        def bfs(p):
            q = deque([p])
            # mark current person as RED group
            color[p] = 0
            while q:
                cur = q.popleft()
                for nei in ds[cur]:
                    if color[nei] == color[cur]:
                        return False
                    if color[nei] == -1:
                        color[nei] = 1 - color[cur]
                        q.append(nei)
            return True

        for i in range(1, n+1):
            if color[i] == -1:
                if not bfs(i):
                    return False

        return True
