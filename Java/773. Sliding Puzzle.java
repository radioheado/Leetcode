class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][] {
            { 1, 3 },
            { 0, 2, 4 },
            { 1, 5 },
            { 0, 4 },
            { 1, 3, 5 },
            { 2, 4 },
        };

        String target = "123450";
        StringBuilder start = new StringBuilder();

        for (int[] row: board) {
            for (int pile: row) {
                start.append(pile);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(start.toString());
        Queue<String> queue = new LinkedList<>();
        queue.add(start.toString());
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }

                int zero_pos = current.indexOf('0');
                for (int new_pos: directions[zero_pos]) {
                    String next_state = swap(current, zero_pos, new_pos);
                    if (visited.contains(next_state)) {
                        continue;
                    }
                    visited.add(next_state);
                    queue.add(next_state);
                }
            }
            moves++;
        }
        
        return -1;
    }

    private String swap(String state, int i, int j) {
        StringBuilder sb = new StringBuilder(state);
        sb.setCharAt(i, state.charAt(j));
        sb.setCharAt(j, state.charAt(i));
        return sb.toString();
    }
}