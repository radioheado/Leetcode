# The read4 API is already defined for you.
# def read4(buf4: List[str]) -> int:

class Solution:
    def __init__(self):
        self.copied = 0
        self.buf4 = [' ']*4
    
    def read(self, buf: List[str], n: int) -> int:
        
        total = 0
        read = 4
        
        # copy the remaining characters from self.last to buf
        if self.copied:
            buf[:self.copied] = self.buf4[:self.copied]
            total += self.copied
            self.copied = 0
        
        while read and total<n:
            buf4 = [' ']*4
            read = read4(buf4)
            buf[total:total+read] = buf4[:read]
            total += read
        
        if total > n:
            self.buf4[:total-n] = buf[n:total]
            self.copied = total-n
        
        return min(total, n)