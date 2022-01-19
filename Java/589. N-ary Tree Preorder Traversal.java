/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while (!s.isEmpty()){
            root = s.pop();
            
            if(root == null){
                continue;
            }
            
            ans.add(root.val);
            Collections.reverse(root.children);
            for(Node c: root.children){
                s.push(c);
            }
        }
        
        return ans;
    }
}