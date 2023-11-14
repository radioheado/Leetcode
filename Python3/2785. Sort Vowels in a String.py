class Solution:
    def sortVowels(self, s: str) -> str:
        chars = defaultdict(int)

        for c in s:
            if c in 'AEIOUaeiou':
                chars[c] += 1

        q = deque()
        for c in 'AEIOUaeiou':
            if c in chars:
                q.extend([c] * chars[c])

        for i, c in enumerate(s):
            if c in 'AEIOUaeiou':
                s = s[:i] + q.popleft() + s[i+1:]

        return s