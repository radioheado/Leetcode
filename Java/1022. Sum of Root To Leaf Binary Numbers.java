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

 // Iterative Solution
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        int total = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque();
        stack.push(new Pair(root, 0));
        
        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> cur = stack.pop();
            root = cur.getKey();
            int path = cur.getValue();
            
            if(root != null){
                path = path*2 + root.val;
                
                // if current node is a leaf node
                if(root.left == null && root.right == null){
                    total += path;
                }else{
                    stack.push(new Pair(root.right, path));
                    stack.push(new Pair(root.left, path));
                }
            }
        }
        
        return total;
    }
}