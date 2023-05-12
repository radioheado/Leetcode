class Solution:
    def dietPlanPerformance(self, calories: List[int], k: int, lower: int, upper: int) -> int:
        total = sum(calories[:k-1])
        score = 0

        for i in range(k-1, len(calories)):
            total += calories[i]
            if total < lower:
                score -= 1
            elif total > upper:
                score += 1
            total -= calories[i - k + 1]
            
        return score