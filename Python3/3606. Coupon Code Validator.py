class Solution:
    def validateCoupons(self, codes: List[str], businessLine: List[str], isActive: List[bool]) -> List[str]:
        lists = [[] for _ in range(4)]
        validLines = ["electronics", "grocery", "pharmacy", "restaurant"]

        for code, bline, active in zip(codes, businessLine, isActive):
            if bline not in validLines or not active or not code:
                continue

            valid = True
            for c in code:
                if not c.isalnum() and c != '_':
                    valid = False
                    break

            if not valid:
                continue

            lists[validLines.index(bline)].append(code)

        ans = []
        for li in lists:
            ans.extend(sorted(li))

        return ans