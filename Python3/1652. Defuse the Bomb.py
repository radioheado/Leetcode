class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        N = len(code)
        # Case 3
        if k == 0:
            return [0] * N

        prefix = [code[0]]
        for c in code[1:]:
            prefix.append(prefix[-1] + c)

        # Case 1: next k numbers
        if k > 0:
            for i, c in enumerate(code):
                if k > N - 1 - i:
                    code[i] = prefix[-1] - prefix[i] + prefix[k - N + i]
                else:
                    code[i] = prefix[i + k] - prefix[i]

        # Case 2: previous k numbers
        else:
            k *= -1
            for i, c in enumerate(code):
                if i == 0:
                    left_part = 0
                elif i > k:
                    left_part = prefix[i - 1] - prefix[i - k - 1] 
                    code[i] = left_part
                    continue
                else:
                    left_part = prefix[i - 1]

                right_part = prefix[N - 1] - prefix[N - 1 - k + i]
                code[i] = left_part + right_part
        
        return code