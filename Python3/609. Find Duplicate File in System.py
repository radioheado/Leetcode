class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        mapping = defaultdict(list)
        
        for p in paths:
            # first half: path
            # second half: files
            p = p.split(' ')
            path = p[0]
            files = p[1:]
            
            # file: name + (content)
            for file in files:
                file = file.split('(')
                name = file[0]
                cont = file[1].rstrip(')')

                mapping[cont].append(path + '/' + name)
        
        ans = []
        for v in mapping.values():
            if len(v) > 1:
                ans.append(v)
        
        return ans