# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        answer = []
        if not root:
            return answer
        
        # use double lists to keep track of the levels
        # nodes at the same level will be included in a list
        # and be appended to answer as a single list
        queue = [[root]]
        
        while queue:
            # what being popped here is a list containing the nodes at the same level
            # so we need to enumerate it
            roots = queue.pop(0)
            
            # use temp to keep track of the nodes at the same level
            temp = []
            
            # use forans to keep track of the value of the nodes
            forans = []
            #print(roots)
            
            for root in roots:
                forans.append(root.val)
                
                if root.left:
                    temp.append(root.left)
                if root.right:
                    temp.append(root.right)
            
            # if we don't add this check, the while loop will never ends
            # because [[]] is not an empty list
            if temp:
                queue.append(temp)
                
            # we do the same for forans so [] will not be appended to answer
            if forans:
                answer.append(forans)
            #print(queue)
            
        return answer
        