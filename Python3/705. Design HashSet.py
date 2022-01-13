# Binary Search Tree Solution
class MyHashSet:

    def __init__(self):
        self.range = 769
        self.buckets = [Bucket() for _ in range(self.range)]

    def add(self, key: int) -> None:
        index = key%self.range
        self.buckets[index].insert(key)

    def remove(self, key: int) -> None:
        index = key%self.range
        self.buckets[index].delete(key)

    def contains(self, key: int) -> bool:
        index = key%self.range
        return self.buckets[index].search(key)

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


# data structure definition for Bucket
class Bucket:
    def __init__(self):
        self.tree = BST()
    
    # insert a node into the bucket 
    def insert(self, val):
        self.tree.root = self.tree.insertBST(self.tree.root, val)
        
    # delete a node in the bucket
    def delete(self, val):
        self.tree.root = self.tree.deleteBST(self.tree.root, val)
        
    # search a node in the bucket
    def search(self, val):
        return self.tree.searchBST(self.tree.root, val)

# basic Tree Node definition
class TreeNode:
    def __init__(self, val: int):
        self.val = val
        self.left = None
        self.right = None
        
# data structure definition for Binary Search Tree        
class BST:
    # a BST uses a root to refer to the whole tree
    def __init__(self):
        self.root = None
        
    # search in a BST
    def searchBST(self, root: TreeNode, val: int) -> bool:
        while root:
            # the val node is in the left subtree
            if root.val > val:
                root = root.left
            
            # the val node is in the right subtree
            elif root.val < val:
                root = root.right
            
            else:
                return True    
        return False
    
    # insert a node into a BST
    def insertBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return TreeNode(val)
        
        # insert the node to the right subtree or left subtree accordingly
        if val > root.val:
            if not root.right:
                root.right = TreeNode(val)
            else:
                root.right = self.insertBST(root.right, val)
        elif val < root.val:
            if not root.left:
                root.left = TreeNode(val)
            else:
                root.left = self.insertBST(root.left, val)
        # if the val already exists, directly return root
        # since we also need to return the modified root
        # we can do it in one line, together
        return root
    
    # find the successor of a given node
    # the successor is the leftmost node in its right subtree
    def successor(self, root: TreeNode) -> TreeNode:
        root = root.right
        while root.left:
            root = root.left
        return root
        
    # find the predecessor of a given node
    # the predecessor is the rightmost node in its left subtree
    def predecessor(self, root: TreeNode) -> TreeNode:
        root = root.left
        while root.right:
            root = root.right
        return root
    
    # delete a node in a BST
    def deleteBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return None
        
        # find the node to delete
        if val == root.val:
            left = root.left
            right = root.right
            
            if not right:
                root = left
                return root
            
            if not left:
                root = right
                return root
            
            # if root has both left and right subtrees
            # find its predecessor first
            # and make itself its left subtree,
            # then attach its right subtree to the predecessor
            pred = self.predecessor(root)
            pred.right = right
            root = left
            return root
        
        elif val > root.val:
            root.right = self.deleteBST(root.right, val)
        else:
            root.left = self.deleteBST(root.left, val)
            
        return root
    

# LinkedList solution
class MyHashSet:

    def __init__(self):
        self.range = 769
        # initiate buckets for each index
        self.buckets = [Bucket() for _ in range(self.range)]

    def add(self, key: int) -> None:
        index = key % self.range
        self.buckets[index].insert(key)

    def remove(self, key: int) -> None:
        index = key % self.range
        self.buckets[index].delete(key)

    def contains(self, key: int) -> bool:
        index = key % self.range
        return self.buckets[index].exists(key)


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

class Bucket:

    def __init__(self):
        # sentinel node as the head
        self.head = LinkedList(0)
    
    # check if a key exists in this bucket
    def exists(self, key: int) -> bool:
        cur = self.head.next
        while cur:
            if cur.val == key:
                return True
            cur = cur.next    
        return False

    # insert a new element to the head
    def insert(self, val: int) -> None:
        # first check if the new value already exists
        if not self.exists(val):
            new = LinkedList(val)
            new.next = self.head.next
            # update the real head
            self.head.next = new
        
    # delete an element
    def delete(self, key: int) -> None:
        
        prev = self.head
        cur = self.head.next
        
        while cur:
            if cur.val == key:
                prev.next = cur.next
                break
            prev = cur
            cur = cur.next
        
# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)

class LinkedList:
    
    def __init__(self, x):
        self.next = None
        self.val = x