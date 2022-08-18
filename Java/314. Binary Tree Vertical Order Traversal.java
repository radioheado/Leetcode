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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null)   return ans;
        
        Map<Integer, List<Integer>> cols = new HashMap();
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList();
        q.offer(new Pair(root, 0));
        int level;
        
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> cur = q.poll();
            root = cur.getKey();
            level = cur.getValue();
            
            if (!cols.containsKey(level)) {
                cols.put(level, new ArrayList<Integer>());
            }
            cols.get(level).add(root.val);
            
            if (root.left != null) {
                q.offer(new Pair(root.left, level - 1));
            }
            
            if (root.right != null) {
                q.offer(new Pair(root.right, level + 1));
            }
        }
        
        List<Integer> sortedKeys = new ArrayList<Integer>(cols.keySet());
        Collections.sort(sortedKeys);
        for (int i: sortedKeys) {
            ans.add(cols.get(i));
        }
        
        return ans;
    }
}