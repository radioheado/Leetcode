class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> boxes_found = new HashSet<>();
        Set<Integer> keys_found = new HashSet<>();
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int box: initialBoxes) {
            if (status[box] == 1) {
                q.add(box);
            } else {
                boxes_found.add(box);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans += candies[cur];

            for (int key: keys[cur]) {
                if (boxes_found.contains(key)) {
                    q.add(key);
                    boxes_found.remove(key);
                } else {
                    keys_found.add(key);
                }
            }

            for (int box: containedBoxes[cur]) {
                if (keys_found.contains(box) || status[box] == 1) {
                    q.add(box);
                    keys_found.remove(box);
                } else {
                    boxes_found.add(box);
                }
            }
        }

        return ans;
    }
}