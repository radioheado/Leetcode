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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        
        List<Triplet<Integer, Integer, Integer>> cols = new ArrayList();
        Queue<Triplet<TreeNode, Integer, Integer>> q = new LinkedList();
        q.offer(new Triplet(root, 0, 0));
        int row, col;
        
        while (!q.isEmpty()) {
            Triplet<TreeNode, Integer, Integer> trip = q.poll();
            root = trip.first;
            row = trip.second;
            col = trip.third;
            
            if (root != null) {
                cols.add(new Triplet(col, row, root.val));
                q.offer(new Triplet(root.left, row+1, col-1));
                q.offer(new Triplet(root.right, row+1, col+1));
            }
        }
        
        Collections.sort(cols, new Comparator<Triplet<Integer, Integer, Integer>>() {
            @Override
            public int compare(Triplet<Integer, Integer, Integer> t1, Triplet<Integer, Integer, Integer> t2) {
                if (t1.first.equals(t2.first)) {
                    if (t1.second.equals(t2.second)) {
                        return t1.third - t2.third;
                    } else {
                        return t1.second - t2.second;
                    }
                } else {
                    return t1.first - t2.first;
                }
            }
        });
        
        List<Integer> curCol = new ArrayList();
        Integer curColIdx = cols.get(0).first, val;
        
        for (Triplet<Integer, Integer, Integer> trip: cols) {
            col = trip.first;
            val = trip.third;
            if (col == curColIdx) {
                curCol.add(val);
            } else {
                ans.add(curCol);
                curColIdx = col;
                curCol = new ArrayList();
                curCol.add(val);
            }
        }
        ans.add(curCol);
        return ans;
    }
}

class Triplet<F, S, T> {
    public final F first;
    public final S second;
    public final T third;
    
    public Triplet(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}