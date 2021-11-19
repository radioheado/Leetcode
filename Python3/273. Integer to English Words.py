class Solution:
    def numberToWords(self, num: int) -> str:
        
        if not num:
            return 'Zero'
        
        digit = {
            1: 'One',
            2: 'Two',
            3: 'Three',
            4: 'Four',
            5: 'Five',
            6: 'Six',
            7: 'Seven',
            8: 'Eight',
            9: 'Nine'
        }
        
        switcher = {
            10: 'Ten',
            11: 'Eleven',
            12: 'Twelve',
            13: 'Thirteen',
            14: 'Fourteen',
            15: 'Fifteen',
            16: 'Sixteen',
            17: 'Seventeen',
            18: 'Eighteen',
            19: 'Nineteen'
        }
        
        tenth = {
            2: 'Twenty',
            3: 'Thirty',
            4: 'Forty',
            5: 'Fifty',
            6: 'Sixty',
            7: 'Seventy',
            8: 'Eighty',
            9: 'Ninety'
        }
        
        higher = {
            1: 'Thousand',
            2: 'Million',
            3: 'Billion'
        }
        
        def three(n):
            temp = ''
            while n:
                #print("goes into three:", n)
                if n//100:
                    temp += digit[n//100]+' Hundred'
                    #print('hundred', temp)
                    n %= 100
                if n//10:
                    if n//10 == 1:
                        if temp and temp[-1]:
                            temp += ' '+switcher[n]
                        else:
                            temp += switcher[n]
                        break
                    else:    
                        if temp and temp[-1]:
                            temp += ' '+tenth[n//10]
                        else:
                            temp += tenth[n//10]
                    #print(temp)
                    n %= 10
                if n:
                    if temp and temp[-1]:
                        temp += ' '+digit[n]
                    else:
                        temp += digit[n]
                    #print(temp)
                    break     
            return temp
        
        count = 0
        ans = ''
        
        while num:
            
            if num//1000000000:
                
                ans += three(num//1000000000)+' Billion'
                num %= 1000000000
            if num//1000000:
                if ans and ans[-1]:
                    ans += ' '+three(num//1000000)+' Million'
                else:
                    ans += three(num//1000000)+' Million'
                num %= 1000000
            if num//1000:
                #print("goes into num//1000:", num//1000)
                if ans and ans[-1]:
                    ans += ' '+three(num//1000)+' Thousand'
                else:
                    ans += three(num//1000)+' Thousand'
                num %= 1000
            if num:
                if ans and ans[-1]:
                    ans += ' '+three(num)
                else:
                    ans += three(num)
                break
                    
        return ans
                