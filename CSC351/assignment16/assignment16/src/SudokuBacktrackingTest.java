import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SudokuBacktrackingTest {
    @Test
    public void emptySudokuPuzzle() {
        int[][] solvedArray = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 1, 4, 3, 6, 5, 8, 9, 7},
                {3, 6, 5, 8, 9, 7, 2, 1, 4},
                {8, 9, 7, 2, 1, 4, 3, 6, 5},
                {5, 3, 1, 6, 4, 2, 9, 7, 8},
                {6, 4, 2, 9, 7, 8, 5, 3, 1},
                {9, 7, 8, 5, 3, 1, 6, 4, 2}
        };
        Board result = new SudokuBacktracking(new Board(new int[9][9])).getSolution();
        Assertions.assertArrayEquals(solvedArray, result.board);
    }

    // I ripped these sudoku's from https://www.247sudoku.com/
    @Test
    public void easySudoku() {
        int[][] solvedArray = {
                {7, 5, 8, 9, 6, 4, 2, 3, 1},
                {6, 9, 2, 3, 1, 5, 8, 4, 7},
                {1, 3, 4, 7, 8, 2, 5, 6, 9},
                {8, 7, 5, 6, 4, 9, 1, 2, 3},
                {2, 4, 6, 1, 5, 3, 9, 7, 8},
                {3, 1, 9, 8, 2, 7, 4, 5, 6},
                {4, 6, 3, 2, 9, 8, 7, 1, 5},
                {9, 2, 7, 5, 3, 1, 6, 8, 4},
                {5, 8, 1, 4, 7, 6, 3, 9, 2}
        };
        int[][] unsolvedArray = {
                {0, 0, 8, 0, 0, 4, 2, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 7},
                {1, 0, 4, 7, 0, 2, 0, 6, 9},
                {0, 0, 0, 6, 0, 0, 0, 0, 0},
                {2, 0, 6, 1, 5, 0, 9, 0, 8},
                {3, 0, 0, 8, 0, 7, 4, 0, 0},
                {4, 0, 3, 2, 0, 0, 0, 0, 5},
                {9, 0, 7, 0, 0, 1, 6, 8, 0},
                {5, 0, 1, 0, 7, 6, 3, 0, 0}
        };
        Board result = new SudokuBacktracking(new Board(unsolvedArray)).getSolution();
        Assertions.assertArrayEquals(solvedArray, result.board);
    }

    @Test
    public void mediumSudoku() {
        int[][] solvedArray = {
                {4, 2, 7, 9, 3, 1, 5, 6, 8},
                {6, 8, 1, 5, 7, 4, 2, 3, 9},
                {9, 3, 5, 2, 8, 6, 4, 1, 7},
                {3, 1, 9, 4, 6, 5, 7, 8, 2},
                {8, 7, 4, 1, 2, 3, 9, 5, 6},
                {5, 6, 2, 8, 9, 7, 3, 4, 1},
                {7, 4, 3, 6, 1, 2, 8, 9, 5},
                {1, 5, 8, 7, 4, 9, 6, 2, 3},
                {2, 9, 6, 3, 5, 8, 1, 7, 4}
        };
        int[][] unsolvedArray = {
                {0, 2, 7, 0, 0, 0, 5, 0, 8},
                {0, 0, 0, 0, 0, 4, 2, 3, 0},
                {9, 3, 0, 0, 0, 6, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 7, 4, 0, 0, 0, 0, 5, 0},
                {5, 0, 0, 8, 9, 0, 0, 0, 0},
                {0, 0, 0, 6, 1, 0, 0, 9, 0},
                {0, 0, 8, 0, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0, 1, 0, 4}
        };
        Board result = new SudokuBacktracking(new Board(unsolvedArray)).getSolution();
        Assertions.assertArrayEquals(solvedArray, result.board);
    }

    @Test
    public void hardSudoku() {
        int[][] solvedArray = {
                {1, 4, 6, 9, 2, 7, 3, 5, 8},
                {9, 8, 5, 1, 3, 4, 6, 2, 7},
                {7, 3, 2, 5, 8, 6, 9, 1, 4},
                {3, 6, 8, 7, 9, 2, 5, 4, 1},
                {4, 7, 9, 8, 1, 5, 2, 3, 6},
                {5, 2, 1, 4, 6, 3, 8, 7, 9},
                {6, 1, 3, 2, 7, 9, 4, 8, 5},
                {2, 5, 7, 6, 4, 8, 1, 9, 3},
                {8, 9, 4, 3, 5, 1, 7, 6, 2}
        };
        int[][] unsolvedArray = {
                {0, 0, 6, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 1, 0, 0, 0, 0, 7},
                {0, 3, 2, 0, 0, 6, 0, 1, 0},
                {3, 0, 0, 7, 0, 0, 0, 0, 0},
                {0, 0, 9, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 4, 6, 0, 8, 7, 0},
                {0, 0, 0, 0, 0, 9, 4, 0, 0},
                {2, 5, 0, 0, 4, 0, 0, 0, 3},
                {8, 0, 0, 0, 0, 1, 0, 0, 0},
        };
        Board result = new SudokuBacktracking(new Board(unsolvedArray)).getSolution();
        Assertions.assertArrayEquals(solvedArray, result.board);
    }

    @Test
    public void expertSudoku() {
        int[][] solvedArray = {
                {8, 9, 3, 5, 4, 2, 7, 1, 6},
                {4, 2, 6, 7, 1, 3, 8, 5, 9},
                {5, 7, 1, 9, 8, 6, 4, 2, 3},
                {3, 1, 9, 4, 2, 5, 6, 7, 8},
                {2, 8, 4, 1, 6, 7, 9, 3, 5},
                {6, 5, 7, 8, 3, 9, 1, 4, 2},
                {1, 3, 5, 6, 9, 4, 2, 8, 7},
                {7, 6, 8, 2, 5, 1, 3, 9, 4},
                {9, 4, 2, 3, 7, 8, 5, 6, 1}
        };
        int[][] unsolvedArray = {
                {0, 0, 0, 0, 4, 0, 0, 0, 6},
                {4, 0, 0, 0, 0, 3, 0, 5, 0},
                {5, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 1, 0, 0, 2, 0, 6, 0, 0},
                {0, 8, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 8, 0, 0, 0, 4, 0},
                {0, 0, 5, 6, 0, 0, 0, 0, 7},
                {0, 0, 0, 0, 0, 1, 3, 0, 0},
                {0, 0, 2, 3, 0, 0, 0, 0, 1}
        };
        Board result = new SudokuBacktracking(new Board(unsolvedArray)).getSolution();
        Assertions.assertArrayEquals(solvedArray, result.board);
    }
}