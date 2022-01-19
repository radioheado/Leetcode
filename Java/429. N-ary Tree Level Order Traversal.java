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
    public List<List<Integer>> levelOrder(Node root) {
        
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        // edge case
        if(root == null){
            return ans;
        }
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                root = q.poll();
                level.add(root.val);
                
                for(Node c: root.children){
                    q.offer(c);
                }
            }
            
            ans.add(level);
        }
        
        return ans;
        
    }
}