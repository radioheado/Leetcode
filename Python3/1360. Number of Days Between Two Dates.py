class Solution:
    def daysBetweenDates(self, date1: str, date2: str) -> int:
        date1 = date1.split('-')
        date2 = date2.split('-')
        
        # make date1 earlier than date2
        if int(''.join(date1)) > int(''.join(date2)):
            return self.daysBetweenDates('-'.join(date2), '-'.join(date1))
        
        months = { 1: 31,
                   2: 28,
                   3: 31,
                   4: 30,
                   5: 31,
                   6: 30,
                   7: 31,
                   8: 31,
                   9: 30,
                  10: 31,
                  11: 30,
                  12: 31,
                 }
        
        y1, m1, d1 = int(date1[0]), int(date1[1]), int(date1[2])
        y2, m2, d2 = int(date2[0]), int(date2[1]), int(date2[2])
        diff = 0
        
        # first count the whole years
        # leap year rules: year%4 == 0 or year%400 == 0
        # year%100 == 0 is not leap year
        for i in range(y1+1, y2):
            if self.isLeap(i):
                diff += 366
            else:
                diff += 365
        
        # count y1
        if y1 == y2:
            # count leap Feb
            #print("y1: %s, y2: %s" %(m1*100+d1, m2*100+d2))
            if self.isLeap(y1) and m1*100+d1 < 229 < m2*100+d2:
                diff += 1
                
            # same month
            if m1 == m2:
                diff += d2-d1
                
            
            else:
                # add m1+1 to m2-1
                for i in range(m1+1, m2):
                    print('a')
                    diff += months[i]
                # add m1
                diff += (months[m1]-d1)
                # add m2
                diff += d2
            
        else:
            # y1 contains leap Feb
            #print("y1: %s, y2: %s" %(m1*100+d1, m2*100+d2))
            if self.isLeap(y1) and m1*100+d1 < 229:
                #print('a')
                diff += 1
                
            # add y1 m1 to Dec
            diff += months[m1]-d1
            for i in range(m1+1, 13):
                diff += months[i]
                
            # add y2 Jan to m2-1
            for i in range(1, m2):
                diff += months[i]
            diff += d2    
            
            # check if y2 is leap year
            if self.isLeap(y2) and m2 > 2:
                diff += 1
        
        return diff
    
    def isLeap(self, year) -> bool:
        if year%400 == 0:
            return True
        elif year%100 == 0:
            return False
        elif year%4 == 0:
            #print(year)
            return True
        else:
            return False
         
            
        
        