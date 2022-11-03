class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freqs = [0] * 26
        a = ord('A')
        
        for t in tasks:
            freqs[ord(t) - a] += 1
            
        freqs.sort()
        fmax = freqs.pop()
        idle = (fmax - 1) * n
        
        # substract available tasks from the max idle time
        while freqs and idle > 0:
            idle -= min(fmax - 1, freqs.pop())
            
        idle = max(0, idle)
        return idle + len(tasks)