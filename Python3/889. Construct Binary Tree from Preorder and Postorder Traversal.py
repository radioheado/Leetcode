# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        def dfs(pre = preorder, post = postorder) -> Optional[TreeNode]:
            if not pre or not post:
                return None

            node = TreeNode(pre[0])
            if len(pre) == 1 or len(post) == 1:
                return node

            left = pre[1]
            right = post[-2]
            idx_l, idx_r = post.index(left), pre.index(right)
            left_child = None
            right_child = None

            # Only one child
            if left == right:
                left_child = dfs(pre[1:], post[:-1])

            else:
                left_child = dfs(pre[1: idx_r], post[: idx_l + 1])
                right_child = dfs(pre[idx_r:], post[idx_l + 1: -1])
            node.left = left_child
            node.right = right_child

            return node

        return dfs()