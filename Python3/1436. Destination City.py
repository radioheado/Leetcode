class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        out = collections.defaultdict(int)
        for frm, to in paths:
            out[frm] += 1
            out[to] = out.get(to, 0)

        for city, degree in out.items():
            if degree == 0:
                return city