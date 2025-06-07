class Solution:
    def robotWithString(self, s: str) -> str:
        chars = Counter(s)
        stack = []
        ans = []
        min_char = 'a'

        for c in s:
            stack.append(c)
            chars[c] -= 1
            while min_char != 'z' and chars[min_char] == 0:
                min_char = chr(ord(min_char) + 1)

            while stack and stack[-1] <= min_char:
                ans.append(stack.pop())

        return ''.join(ans)