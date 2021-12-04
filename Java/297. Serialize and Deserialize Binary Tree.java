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
        return dfs1(root, "");
    }
    
    private String dfs1(TreeNode node, String str){
        if(node == null){
            str += "null,";
        }else{
            str += str.valueOf(node.val) + ",";
            str = dfs1(node.left, str);
            str = dfs1(node.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_list = data.split(",");
        List<String> data_l = new LinkedList<String> (Arrays.asList(data_list));
        return dfs2(data_l);
    }
    
    private TreeNode dfs2(List<String> l){
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = dfs2(l);
        node.right = dfs2(l);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));