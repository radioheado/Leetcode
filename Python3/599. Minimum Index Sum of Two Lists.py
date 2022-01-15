class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        map2 = {}
        for i, r in enumerate(list2):
            map2[r] = i
            
        ans = []
        sumIdx = float('inf')
        
        for i, r in enumerate(list1):
            if r in map2:
                # if index sum is less
                indices = i + map2[r]
                if indices == sumIdx:
                    ans.append(r)
                elif indices < sumIdx:
                    ans = []
                    ans.append(r)
                    sumIdx = indices
                
        return ans