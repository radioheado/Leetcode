class Solution:
    def repeatLimitedString(self, s: str, repeatLimit: int) -> str:
        letters = Counter(s)
        heap = [(-ord(c), n) for c, n in letters.items()]
        heapify(heap)

        ans = []
        while len(heap) > 1:
            o, n = heappop(heap)
            char = chr(-o)

            # Need to find the next largest char
            # And only append 1 of it to the answer
            if ans and char == ans[-1]:
                seco, secn = heappop(heap)
                nxt_char = chr(-seco)
                ans.append(nxt_char)
                if secn - 1 > 0:
                    heappush(heap, (seco, secn - 1))
                heappush(heap, (o, n))

            else:
                num = min(repeatLimit, n)
                ans.extend([char] * num)
                if n - num > 0:
                    heappush(heap, (o, n - num))

        if not ans or ans and ans[-1] != chr(-heap[-1][0]):
            o, n = heappop(heap)
            char = chr(-o)
            num = min(repeatLimit, n)
            ans.extend([char] * num)
                
        return ''.join(ans)