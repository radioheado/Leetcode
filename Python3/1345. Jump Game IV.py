class Solution:
    def minJumps(self, arr: List[int]) -> int:
        N = len(arr)
        graph = collections.defaultdict(list)

        for i, n in enumerate(arr):
            graph[n].append(i)

        q = [0]
        visited = {0}
        steps = 0

        while q:
            new_q = []

            for node in q:
                # reach the goal
                if node == N - 1:
                    return steps

                # check the indices that i-th can jump to
                for child in graph[arr[node]]:
                    if child not in visited:
                        visited.add(child)
                        new_q.append(child)

                # clear the current node's list to prevent re-visiting
                del graph[arr[node]]

                # check the left and right neighbors
                for child in [node - 1, node + 1]:
                    if 0 <= child < N and child not in visited:
                        visited.add(child)
                        new_q.append(child)

            q = new_q
            steps += 1

        return -1