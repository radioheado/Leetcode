class Solution:
    def toLowerCase(self, str: str) -> str:
        a = ord('a')
        A = ord('A')
        
        for i in range(len(str)):
            tmp = ord(str[i])
            if 65 <= tmp <= 90:
                str = str[:i] + chr(tmp-A+a) + str[i+1:]
        
        return str
                