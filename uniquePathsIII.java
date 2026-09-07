public class uniquePathsIII {
    public int uniquePaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int startRow = 0, startCol = 0;
        int empty = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        return backtrack(grid, startRow, startCol, empty);
    }

    private int backtrack(int[][] grid, int row, int col, int empty) {
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length ||
            grid[row][col] == -1) {
            return 0;
        }
        if (grid[row][col] == 2) {
            return empty == -1 ? 1 : 0;
        }
        grid[row][col] = -1;
        int paths = 0;
        paths += backtrack(grid, row + 1, col, empty - 1);
        paths += backtrack(grid, row - 1, col, empty - 1);
        paths += backtrack(grid, row, col + 1, empty - 1);
        paths += backtrack(grid, row, col - 1, empty - 1);

        // Backtrack: make cell available again
        grid[row][col] = 0;

        return paths;
    }
}
