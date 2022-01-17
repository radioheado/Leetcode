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
class BSTIterator {

    Queue<TreeNode> q;
    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inorder(root);
    }
    
    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        
        if(node.left != null){
            inorder(node.left);
        }
        
        q.add(node);
        
        if(node.right != null){
            inorder(node.right);
        }
    }
    
    public int next() {
        TreeNode node = q.poll();
        return node.val;
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */