class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        
        ''' 在该乘法表中，最小值是1，最大值是m*n。
            所以我们初始化left = 1, right = m * n。
            每次首先得到left和right的中值mid，然后计算比mid小的数一种有多少个，而这个可以用O(m)的时间复杂度即可获得。
            如果比mid小的数小于k，说明我们要求的数在区间[mid + 1, right]内；否则说明我们要求的数在[left, mid - 1]。
            最终当left > right的时候，left即为我们所求。
            该算法的空间复杂度是O(1)，时间复杂度是O(nlog(m*n))。
            由于在测试用例中k往往大于n，相当于n^2的量级，所以相比于Smart Heap，该算法的时间复杂度也要低一个量级。
            ————————————————
            版权声明：本文为CSDN博主「魔豆Magicbean」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
            原文链接：https://blog.csdn.net/magicbean2/article/details/79192797
        '''
        
        left, right = 1, m*n
        
        while left <= right:
            mid = (left+right)//2
            count = 0
            for row in range(1, m+1):
                count += min(n, mid//row)
            if count < k:
                left = mid+1    
            else:
                right = mid-1
                
        return left