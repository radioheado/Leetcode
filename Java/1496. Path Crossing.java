class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet();
        visited.add(new Pair(0, 0));

        for (char p: path.toCharArray()) {
            if (p == 'N') {
                y++;
            } else if (p == 'S') {
                y--;
            } else if (p == 'E') {
                x++;
            } else {
                x--;
            }

            if (visited.contains(new Pair(x, y))) {
                return true;
            }

            visited.add(new Pair(x, y));
        }
        return false;
    }
}