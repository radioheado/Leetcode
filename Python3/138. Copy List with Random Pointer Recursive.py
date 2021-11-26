"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

# Graphic (recursion) solution
class Solution:
    
    # use the visited dictionary to keep track of nodes that are already visited
    # since 
    def __init__(self):
        self.visited = {}
        
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        
        # if head is already visited, return the cloned version of it
        if head in self.visited:
            return self.visited[head]
        
        # if head is not visited, create a new Node and add it to visited
        cur = Node(head.val, None, None)
        self.visited[head] = cur
        
        # recursively clone the next and random node of head
        cur.next = self.copyRandomList(head.next)
        cur.random = self.copyRandomList(head.random)
        
        return cur