/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root, new StringBuilder());
        if(sb.length() > 0){
            // delete the last ' '
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    
    private StringBuilder postorder(TreeNode node, StringBuilder sb){
        if(node == null){
            return sb;
        }
        postorder(node.left, sb);
        postorder(node.right, sb);
        sb.append(node.val);
        sb.append(' ');
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for(String s: data.split("\\s+")){
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
    
    private TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums){
        if(nums.isEmpty()){
            return null;
        }
        
        if(nums.getLast()<lower || nums.getLast()>upper){
            return null;
        }
        
        int val = nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;