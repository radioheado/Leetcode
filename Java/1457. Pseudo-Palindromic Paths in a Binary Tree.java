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
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null)   return 0;
        
        Stack<Pair<TreeNode, Set<Integer>>> stack = new Stack();
        stack.push(new Pair<TreeNode, Set<Integer>> (root, new HashSet()));
        int ans = 0;
        
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            root = (TreeNode) cur.getKey();
            Set<Integer> count = (HashSet) cur.getValue();
            
            if (count.contains(root.val)) {
                count.remove(root.val);
            } else {
                count.add(root.val);
            }
            
            if (root.left == null && root.right == null) {
                if (count.size() <= 1) {
                    ans++;
                }
                continue;
            }
            
            if (root.right != null) {
                stack.push(new Pair(root.right, new HashSet(count)));
            }
            if (root.left != null) {
                stack.push(new Pair(root.left, new HashSet(count)));
            }
        }
        
        return ans;
    }
}