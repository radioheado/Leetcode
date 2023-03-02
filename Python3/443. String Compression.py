class Solution:
    def compress(self, chars: List[str]) -> int:
        if len(chars) == 1:
            return 1

        last = ans = 0
        count = 1
        prev = chars[0]

        for c in chars[1:]:
            
            if c == prev:
                count += 1

            else:
                chars[last] = prev
                last += 1
                ans += 1
 
                if count > 1:
                    count = str(count)
                    ans += len(count)
                    for d in count:
                        chars[last] = d
                        last += 1

                prev = c
                count = 1

        chars[last] = prev
        ans += 1
        last += 1

        if count > 1:
            count = str(count)
            ans += len(count)
            for d in count:
                chars[last] = d
                last += 1

        return ans