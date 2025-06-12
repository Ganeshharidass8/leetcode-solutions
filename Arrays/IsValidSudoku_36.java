import java.util.HashSet;

class IsValidSudoku_36 {
    /**
     * This method checks whether a given 9x9 Sudoku board is valid.
     * 
     * @param board The input 9x9 Sudoku board.
     * @return True if the board is valid, otherwise false.
     */
    public boolean isValidSudoku(char[][] board) {
        // Create hash sets for rows, columns, and sub-boxes (3x3 grids)
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxIndex = new HashSet[9];

        // Initialize hash sets for each row, column, and sub-box
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxIndex[i] = new HashSet<>();
        }

        // Traverse the board row by row and column by column
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells
                if (board[r][c] == '.') {
                    continue;
                }

                // Get the value of the current cell
                char value = board[r][c];
                // Calculate the index of the 3x3 sub-box
                int index = (r / 3) * 3 + (c / 3);

                // Check if the value has already appeared in the row, column, or sub-box
                if (rows[r].contains(value) || cols[c].contains(value) || boxIndex[index].contains(value)) {
                    return false; // If it appears in any, return false
                }

                // Add the value to the respective row, column, and sub-box
                rows[r].add(value);
                cols[c].add(value);
                boxIndex[index].add(value);
            }
        }

        // If no duplicates were found, the board is valid
        return true;
    }
}
/**
 * Box Index by formula index = (row/3)*3+(col/3)
 * 
 * | Row (r) | Column (c) | Box Index |
 * | ------- | ---------- | --------- |
 * | 0–2 | 0–2 | 0 |
 * | 0–2 | 3–5 | 1 |
 * | 0–2 | 6–8 | 2 |
 * | 3–5 | 0–2 | 3 |
 * | 3–5 | 3–5 | 4 |
 * | 3–5 | 6–8 | 5 |
 * | 6–8 | 0–2 | 6 |
 * | 6–8 | 3–5 | 7 |
 * | 6–8 | 6–8 | 8 |
 * 
 */