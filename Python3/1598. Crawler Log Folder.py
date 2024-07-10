class Solution:
    def minOperations(self, logs: List[str]) -> int:
        ans = 0
        for log in logs:
            # Stay
            if log == './':
                continue

            # Move to the parent folder
            elif log == '../':
                ans = max(0, ans - 1)

            # Move to a child folder
            else:
                ans += 1

        return ans