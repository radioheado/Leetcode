class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        # For the tree-alike graph
        # the number of centroids is no more than 2
        
        # special cases
        if n <= 2:
            return [i for i in range(n)]

        adjs = defaultdict(set)
        for u, v in edges:
            adjs[u].add(v)
            adjs[v].add(u)

        # initialize the first layer of leaves
        leaves = []
        for i in range(n):
            if len(adjs[i]) == 1:
                leaves.append(i)

        remaining = n

        while remaining > 2:
            size = len(leaves)
            remaining -= size
            next_leaves = []

            for _ in range(size):
                leaf = leaves.pop()
                # because this is a leaf node, there's only one neighbor
                neighbor = adjs[leaf].pop()

                # remove this only edge from neighbor
                adjs[neighbor].discard(leaf)

                # check if this is a new leaf node
                if len(adjs[neighbor]) == 1:
                    next_leaves.append(neighbor)

            leaves = next_leaves

        return leaves 