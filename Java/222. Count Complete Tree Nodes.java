/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int h = getHeight(root);
        /* the tree has only one node */
        if (h == 0) {
            return 1;
        }
        
        int l = 0, r = (int)Math.pow(2, h) - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (exists(root, h, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return (int)Math.pow(2, h) - 1 + l;
    }
    
    private boolean exists(TreeNode root, int h, int idx) {
        int l = 0, r = (int)Math.pow(2, h) - 1, mid;
        for (int i=0; i<h; i++) {
            mid = l + (r - l) / 2;
            if (idx <= mid) {
                root = root.left;
                r = mid;
            } else {
                root = root.right;
                l = mid + 1;
            }
        }
        return root != null;
    }
    
    private int getHeight(TreeNode root) {
        int h = 0;
        while (root.left != null) {
            root = root.left;
            h++;
        }
        return h;
    }
}