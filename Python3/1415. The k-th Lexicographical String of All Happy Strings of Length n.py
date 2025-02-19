class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        portion = 1 << (n - 1)
        if 3 * portion < k:
            return ''

        next_smallest = {"a": "b", "b": "a", "c": "a"}
        next_greatest = {"a": "c", "b": "c", "c": "b"}

        ans = ['a'] * n
        start_a = 1
        start_b = start_a + portion
        start_c = start_b + portion

        if k < start_b:
            k -= start_a
        elif k < start_c:
            ans[0] = 'b'
            k -= start_b
        else:
            ans[0] = 'c'
            k -= start_c

        for char_idx in range(1, n):
            portion //= 2

            if k < portion:
                ans[char_idx] = next_smallest[ans[char_idx - 1]]
            else:
                ans[char_idx] = next_greatest[ans[char_idx - 1]]
                k -= portion

        return ''.join(ans)