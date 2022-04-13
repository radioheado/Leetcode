class Solution:
    def average(self, salary: List[int]) -> float:
        total = count = 0
        minn = inf
        maxx = -inf
        
        for n in salary:
            total += n
            count += 1
            minn = min(minn, n)
            maxx = max(maxx, n)
            
        return (total - minn - maxx) / (count - 2)