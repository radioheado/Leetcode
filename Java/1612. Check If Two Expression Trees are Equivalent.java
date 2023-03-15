/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] vals1 = new int[26];
        int[] vals2 = new int[26];
        dfs(root1, vals1);
        dfs(root2, vals2);
        return Arrays.equals(vals1, vals2);
    }

    private void dfs(Node node, int[] vals) {
        if (node.val != '+') {
            vals[node.val - 'a']++;
            return;
        }
        dfs(node.left, vals);
        dfs(node.right, vals);
    }
}