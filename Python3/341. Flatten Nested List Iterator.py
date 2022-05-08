# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger:
#    def isInteger(self) -> bool:
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        """
#
#    def getInteger(self) -> int:
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        """
#
#    def getList(self) -> [NestedInteger]:
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        """

class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.stack = deque([[nestedList, 0]])
    
    def next(self) -> int:
        self.getInt()
        l, i = self.stack[-1]
        self.stack[-1][1] += 1
        return l[i].getInteger()
    
    def hasNext(self) -> bool:
        self.getInt()
        return len(self.stack) > 0
    
    def getInt(self) -> None:
        while self.stack:
            l, i = self.stack[-1]
            
            # case 1: top of the stack has been read completed, pop it
            if len(l) == i:
                self.stack.pop()
                continue
            
            # case 2: top is an integer, we are all set
            if l[i].isInteger():
                break
                
            # case 3: top is a nested list, 
            # increment the pointer index, 
            # and add the new list to the stack
            nl = l[i].getList()
            self.stack[-1][1] += 1
            self.stack.append([nl, 0])
            
    
    
# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())