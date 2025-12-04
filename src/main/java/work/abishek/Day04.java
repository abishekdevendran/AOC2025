package work.abishek;

import java.util.ArrayList;
import java.util.List;

public class Day04 {
    private final char[][] grid;
    private final int rows;
    private final int cols;

    public Day04(List<String> lines) {
        this.rows = lines.size();
        this.cols = lines.getFirst().length(); // Assumes rectangular grid
        this.grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            this.grid[i] = lines.get(i).toCharArray();
        }
    }

    public long p1() {
        long count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Only check neighbors if the current cell IS a paper roll
                if (grid[r][c] == '@' && countNeighbors(grid, r, c) < 4) {
                    count++;
                }
            }
        }
        return count;
    }

    int countNeighbors(char[][] g, int r, int c) {
        int neighbors = 0;
        // 1. Get dimensions from the PASSED grid, not the class fields
        int currentRows = g.length;
        int currentCols = g[0].length;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;

                int nr = r + dr;
                int nc = c + dc;

                // 2. Use the local dimensions for bounds checking
                if (nr >= 0 && nr < currentRows &&
                        nc >= 0 && nc < currentCols &&
                        g[nr][nc] == '@') {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }

    public long p2() {
        // 1. Create a deep copy of the grid
        char[][] workGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            workGrid[i] = grid[i].clone();
        }

        long totalRemoved = 0;

        while (true) {
            // Use a list to store candidates for this round (Batching)
            List<Point> toRemove = new ArrayList<>();

            // 2. Scan: Find all removable items based on CURRENT state
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (workGrid[r][c] == '@' && countNeighbors(workGrid, r, c) < 4) {
                        toRemove.add(new Point(r, c));
                    }
                }
            }

            // 3. Termination: If nothing changed, we are done
            if (toRemove.isEmpty()) {
                break;
            }

            // 4. Update: Execute removals
            for (Point p : toRemove) {
                workGrid[p.r][p.c] = '.'; // Mark as removed (or 'x')
                totalRemoved++;
            }
        }

        return totalRemoved;
    }

    // Simple data carrier
    private record Point(int r, int c) {
    }
}
