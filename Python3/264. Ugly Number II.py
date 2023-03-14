class Solution:
    def nthUglyNumber(self, n: int) -> int:
        i2 = i3 = i5 = 0
        res = [1]
        while len(res) < n:
            n2, n3, n5 = res[i2] * 2, res[i3] * 3, res[i5] * 5
            res += [min(n2, n3, n5)]
            if res[-1] == n2: i2 += 1
            if res[-1] == n3: i3 += 1
            if res[-1] == n5: i5 += 1
            #print('res = %d' %res[-1])
        return res[-1]