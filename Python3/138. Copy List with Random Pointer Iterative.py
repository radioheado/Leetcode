"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    
    def __init__(self):
        self.visited = {}
    
    def getClonedNode(self, node):
        if not node:
            return None
        
        # use setdefault to return the cloned node if it exists, otherwise create it
        return self.visited.setdefault(node, Node(node.val, None, None))
    
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        # use old to iterate the LinkedList
        old = head
        # create the new head node
        new = Node(old.val, None, None)
        self.visited[head] = new
        
        # iterate the LinkedList
        while old:
            
            new.random = self.getClonedNode(old.random)
            new.next = self.getClonedNode(old.next)
            
            # move to the next node
            old = old.next
            new = new.next
            
        return self.visited[head]
        
        