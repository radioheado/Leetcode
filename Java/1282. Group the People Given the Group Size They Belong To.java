class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap();
        for (int i = 0; i < groupSizes.length; i++) {
            groups.computeIfAbsent(groupSizes[i], v -> new ArrayList()).add(i);
        }

        List<List<Integer>> ans = new ArrayList();
        for (int group: groups.keySet()) {
            for (int i = 0; i < groups.get(group).size(); i += group) {
                ans.add(groups.get(group).subList(i, i+group));
            }
        }
        
        return ans;
    }
}