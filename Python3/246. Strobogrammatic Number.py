class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        valid = ('0','1','6','8','9')
        mapping = {'0':0, '1':1, '6':9, '8':8, '9':6}
        rotation = 0
        
        for i in range(1,len(num)+1):
            if num[-i] not in valid:
                return False
            rotation = rotation*10 + mapping[num[-i]]
            if str(rotation) != num[:i]:
                #print('early')
                return False
            
        return True if str(rotation) == num else False