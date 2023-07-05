class Solution:
    def maximumRequests(self, n: int, requests: List[List[int]]) -> int:
        ans = 0
        indegree = [0] * n

        def backtrack(start: int, count: int) -> None:
            if start == len(requests):
                nonlocal ans
                for i in range(n):
                    if indegree[i] != 0:
                        return
                
                ans = max(ans, count)
                return
            
            indegree[requests[start][0]] -= 1
            indegree[requests[start][1]] += 1
            # accept this request and move on
            backtrack(start + 1, count + 1)
            indegree[requests[start][0]] += 1
            indegree[requests[start][1]] -= 1

            # ignore this request and move on
            backtrack(start + 1, count)
    
        backtrack(0, 0)
        return ans      