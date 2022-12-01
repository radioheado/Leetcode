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
    private int prev;
    private Stack<TreeNode> stack;
    private List<Integer> arr;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack();
        arr = new ArrayList();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        prev = -1;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || prev < arr.size() - 1;
    }
    
    public int next() {
        prev++;
        if (prev == arr.size()) {
            TreeNode node = stack.pop();
            arr.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return arr.get(prev);
    }
    
    public boolean hasPrev() {
        return prev > 0;
    }
    
    public int prev() {
        return arr.get(--prev);   
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */