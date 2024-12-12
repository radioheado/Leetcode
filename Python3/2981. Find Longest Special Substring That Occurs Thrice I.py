class Solution:
    def maximumLength(self, s: str) -> int:
        str_count = defaultdict(int)
        count = 1
        str_count[s[0] + '1'] = 1
        ans = -1

        for i, c in enumerate(s[1:], 1):
            if c == s[i - 1]:
                count += 1
            else:
                count = 1

            for j in range(1, count + 1):
                str_count[c + str(j)] += 1
                if str_count[c + str(j)] >= 3:
                    ans = max(ans, j)

        #print(str_count)
        return ans