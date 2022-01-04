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
    Map<String, LinkedList<TreeNode>> cache;
    
    public List<TreeNode> generateTrees(int n) {
        cache = new HashMap<>();
        return construct(1, n);
    }
    
    private LinkedList<TreeNode> construct(int start, int end){
        LinkedList<TreeNode> trees = new LinkedList<>();
        String index = Integer.toString(start) + "+" + Integer.toString(end);
        //System.out.println(index);
        if(start > end){
            trees.add(null);
            return trees;
        }
        
        if(cache.containsKey(index)){
            return cache.get(index);
        }
        
        for(int i=start; i<=end; i++){
            LinkedList<TreeNode> left = construct(start, i-1);
            LinkedList<TreeNode> right = construct(i+1, end);
            
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    trees.add(cur);
                }
            }
        }
        
        cache.put(index, trees);
        return trees;
    }
    
}