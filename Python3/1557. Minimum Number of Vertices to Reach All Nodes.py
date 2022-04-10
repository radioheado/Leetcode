class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        indegree = set([x for x in range(n)])
        for u, v in edges:
            indegree.discard(v)
            
        return list(indegree)