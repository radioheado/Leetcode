# Iterative Solution
# Time Complexity:  O(N * 2^N), where N = len(s). 
#                   There could be 2^N possible substrings in the worst case:
#                       At each character we have 2 choices:
#                           - don't start a new partition or
#                           - start a new partition
#                       For each choice, we need O(n) time to both: check if palindrome & slice substring
#                   Together, O((n + n) * 2^n) -> O(2n * 2^n) -> O(n * 2^n)
# Space Complexity: O(N * N). The visited dict records N + (N-1) + ... + 1 status
class Solution:
    
    # a helper function to check if a substring of s is a palindrome
    def palindrome(self, s: str, start: int, end: int) -> bool:
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True
    
    
    def partition(self, s: str) -> List[List[str]]:
        
        ans = []
        visited = {}
        
        q = deque([[0, []]])
        
        while q:
            start, path = q.popleft()
            
            if start == len(s):
                ans.append(path)
            
            for end in range(start, len(s)):
                if (start, end) in visited:
                    status = visited[(start, end)]
                else:
                    status = self.palindrome(s, start, end)
                    
                if status:
                    q.append([end+1, path + [s[start: end+1]]])
                    
                visited[(start, end)] = status
                
        return ans
                    

# Recursive Solution
# Same Time and Space Complexity
class Solution:
    
    # a helper function to check if a substring of s is a palindrome
    def palindrome(self, s: str, start: int, end: int) -> bool:
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True
    
    def partition(self, s: str) -> List[List[str]]:
        
        self.ans = []
        self.visited = {}
        
        def dfs(start, part):
            if start == len(s):
                self.ans.append(part)
                
            for end in range(start, len(s)):
                # get the status of the substring (palindrome or not): true or false
                if (start, end) in self.visited:
                    status = self.visited[(start, end)]
                else:
                    status = self.palindrome(s, start, end)
                
                
                # if the substring is a palindrome
                if status:
                    dfs(end+1, part + [s[start: end+1]])
        
                # add the substring to visited
                self.visited[(start, end)] = status
            
                #print("current substring: %s, current partition: %s, temp answer = %s" %(s[start:end+1], part, self.ans))
                
        dfs(0, [])
        return self.ans        