class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        # save the components such that groups of nodes are kept in a key
        # then we'll sort the chars to get the minimum
        # and make a result string according to the start indexes
        components = collections.defaultdict(list)
        
        dsu = DSU(len(s))
        
        for pair in pairs:
            # merge two nodes, if they have the same root, count will not decrement
            # if we have only one root, then it means that the chars are all connected
            # thus, we can sort the whole string directly
            # don't forget to add ''.join if using sorted() and list.sort()
            dsu.union(pair[0], pair[1])
            if dsu.getCount() == 1:
                return ''.join(sorted(s))
                
        for i in range(len(s)):
            # update the root for each char in case that some of them have not been visited after the initial check
            # add the char to its root in the dict accordingly 
            # thus, we'll get all the components formed in this relationship
            # then, we'll sort the components respectively
            root = dsu.find(i)
            components[root].append(i)
        
        # we'll fill in the chars directly to the answer list
        # don't forget to add ''.join to transfer a list to a string
        ans = [None]*len(s)
        
        for node in components.values():
            # use this list to store the index of the char that needs to be filled in to ans
            index = []  
            
            # use this list to store the chars that indicated by the indexes from s
            # then sort this list to get a sorted component
            char = []
            for i in node:
                index.append(i)
                char.append(s[i])
            
            # sort the chars, and fill it to the index
            # index list is intact, which indicates the location of each char to be filled in
            char.sort()
            for i in range(len(char)):
                ans[index[i]] = char[i]
        
        return ''.join(ans)
        
        
class DSU:
    def __init__(self, size):
        self.root = [i for i in range(size)]
        self.rank = [1]*size
        self.count = size
        
    def find(self, x):
        if x != self.root[x]:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    
    def union(self, a, b):
        x = self.find(a)
        y = self.find(b)
        
        # different roots, merge the two nodes
        # this means we find another component
        if x != y:
            self.count -= 1
            if self.rank[x] < self.rank[y]:
                self.root[x] = y
            elif self.rank[x] > self.rank[y]:
                self.root[y] = x
            else:
                self.root[x] = y
                self.rank[y] += 1
                
    def getCount(self):
        return self.count