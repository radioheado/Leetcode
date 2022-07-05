class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key = lambda x: (-x[1], x[0]))
        weight = 0
        
        for num, unit in boxTypes:
            available = min(truckSize, num)
            weight += available * unit
            truckSize -= available
            if truckSize == 0:
                break
            
        return weight
                