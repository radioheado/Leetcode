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
    Map<String, List<TreeNode>> patterns;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        patterns = new HashMap<>();
        dfs(root);
        
        List<TreeNode> ans = new ArrayList<>();
        for(List<TreeNode> nodes: patterns.values()){
            if(nodes.size() > 1){
                ans.add(nodes.get(0));
            }
        }
        
        return ans;
    }
    
    private String dfs(TreeNode node){
        if(node == null){
            return "null";
        }
        
        String ptn = Integer.toString(node.val);
        
        String left = dfs(node.left);
        String right = dfs(node.right);
        
        if(node.left == null && node.right == null){
            ;
        }else{
            ptn += "," + left + "," + right;
        }
        
        if(!patterns.containsKey(ptn)){
            patterns.put(ptn, new ArrayList<TreeNode>());
        }
        patterns.get(ptn).add(node);
        return ptn;
    }
}