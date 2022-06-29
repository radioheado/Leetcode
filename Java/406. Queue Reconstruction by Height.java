class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                // for the same heights, smaller k-value first
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        
        List<int[]> queue = new LinkedList<>();
        for (int[] p: people) {
            queue.add(p[1], p);
        }
        
        return queue.toArray(new int[people.length][2]);
    }
}