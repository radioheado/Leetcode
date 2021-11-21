class Solution:
    def validIPAddress(self, queryIP: str) -> str:
        
        hexs = set(str(i) for i in range(10))
        hexs.update('abcdefABCDEF')
        #print(set('2001').issubset(hexs))
        
        def ipv4(s: str) -> bool:
            ss = s.split('.')
            #print(ss)
            # s should have exactly 4 sub addresses
            if len(ss) != 4:
                return False
            
            for i in ss:
                #print(i)
                # length should be less than or equal to 3 but not 0
                if len(i)>3 or len(i) == 0:
                    return False
                # no leading zeros for string length larger than 1
                if len(i) > 1 and i[0] == '0':
                    return False
                # if i contains nondigits
                if not i.isdigit():
                    print(i)
                    return False
                # if i is out of the range [0, 255]
                if int(i) > 255 or int(i) < 0:
                    return False
                
            return True
                
        
        def ipv6(s: str) -> bool:
            ss = s.split(':')
            #print(ss)
            # s should have exactly 8 sub addresses
            if len(ss) != 8:
                return False
            
            for i in ss:
                #print(i)
                #print(set(i))
                # 1 <= length <= 4
                if len(i) > 4 or len(i) == 0:
                    return False
                
                if not set(i).issubset(hexs):
                    return False
            
            return True
        
        
        if not ipv4(queryIP) and not ipv6(queryIP):
            return "Neither"
        if ipv4(queryIP):
            return "IPv4"
        if ipv6(queryIP):
            return "IPv6"
        