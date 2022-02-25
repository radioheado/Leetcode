class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        p1 = p2 = 0
        version1 = version1.split('.')
        version2 = version2.split('.')
        
        # if passed the first while loop, the two versions 
        # have the same valued prefix
        while p1 < len(version1) and p2 < len(version2):
            if int(version1[p1]) > int(version2[p2]):
                return 1
            elif int(version1[p1]) < int(version2[p2]):
                return -1
            p1 += 1
            p2 += 1
        
        # edge case: the rest of the longer version is just 0
        while p1 < len(version1):
            if int(version1[p1]) != 0:
                return 1
            p1 += 1
            
        while p2 < len(version2):
            if int(version2[p2]) != 0:
                return -1
            p2 += 1
            
        return 0
        