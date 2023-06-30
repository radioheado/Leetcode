class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        DSU dsu = new DSU(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = cells.length - 1; i >= 0; i--) {
            int r = cells[i][0] - 1, c = cells[i][1] - 1;
            int index1 = r * col + c + 1;
            grid[r][c] = 1;

            for (int[] d: directions) {
                int x = r + d[0], y = c + d[1];
                int index2 = x * col + y + 1;
                if (0 <= x && x < row && 0 <= y && y < col && grid[x][y] == 1) {
                    dsu.union(index1, index2);
                }
            }

            if (r == 0) {
                dsu.union(0, index1);
            }
            if (r == row - 1) {
                dsu.union(row * col + 1, index1);
            }
            if (dsu.connected()) {
                return i;
            }
        }

        return -1;
    }


}

class DSU {
    int[] root, rank;

    public DSU (int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    public int find (int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    public void union (int x, int y) {
        int rootx = find(x), rooty = find(y);
        int rankx = rank[rootx], ranky = rank[rooty];

        if (rootx != rooty) {
            if (rankx > ranky) {
                root[rooty] = rootx;
            } else if (rankx < ranky) {
                root[rootx] = rooty;
            } else {
                root[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public boolean connected () {
        return find(0) == find(root.length - 1);
    }
}