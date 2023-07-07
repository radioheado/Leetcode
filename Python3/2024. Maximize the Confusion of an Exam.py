class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        ans = k
        count = Counter(answerKey[:k])
        l = 0

        for r, c in enumerate(answerKey[k:], k):
            count[c] += 1

            while min(count['T'], count['F']) > k:
                count[answerKey[l]] -= 1
                l += 1

            ans = max(ans, r - l + 1)

        return ans