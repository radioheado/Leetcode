class Solution:
    def reorganizeString(self, s: str) -> str:
        most = 0
        chars = collections.defaultdict(int)

        for c in s:
            chars[c] += 1

        ans = ''
        heap = [[-v, c] for c, v in chars.items()]
        heapq.heapify(heap)

        while len(heap) > 1:
            top = heapq.heappop(heap)
            sec = heapq.heappop(heap)
            ans += top[1] + sec[1]
            if sec[0] < -1:
                heapq.heappush(heap, [sec[0] + 1, sec[1]])
            if top[0] < -1:
                heapq.heappush(heap, [top[0] + 1, top[1]])
        
        if not heap:
            return ans
        elif heap and heap[0][0] == -1:
            ans += heap[0][1]
            return ans
        else:
            return ''