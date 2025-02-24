class Solution:
    def mostProfitablePath(self, edges: List[List[int]], bob: int, amount: List[int]) -> int:
        # Make the graph
        adjs = defaultdict(list)
        for u, v in edges:
            adjs[u].append(v)
            adjs[v].append(u)

        # Find the path that Bob moves
        bob_time = [len(amount) + 1] * len(amount)
        queue = deque([(bob, [bob])])
        visited = set([bob])
        bob_path = []

        while queue:
            level = len(queue)
            for _ in range(level):
                node, path = queue.popleft()
                if node == 0:
                    bob_path = path[:]
                    break

                for child in adjs[node]:
                    if child not in visited:
                        visited.add(child)
                        queue.append((child, path + [child]))

        for i, n in enumerate(bob_path):
            bob_time[n] = i

        ans = -inf
        # (node, profit so far)
        queue = deque([(0, 0)])
        time = 0
        visited = set([0])

        while queue:
            level = len(queue)
            for _ in range(level):
                node, profit = queue.popleft()
                isLeaf = True

                # They meet here and share
                if bob_time[node] == time:
                    profit += amount[node] // 2
                elif bob_time[node] > time:
                    profit += amount[node]

                for child in adjs[node]:
                    if child not in visited:
                        isLeaf = False
                        visited.add(child)
                        queue.append((child, profit))

                if isLeaf:
                    ans = max(ans, profit)

            time += 1

        return ans