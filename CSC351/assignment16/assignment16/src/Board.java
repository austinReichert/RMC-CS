import java.util.ArrayList;
import java.util.List;

class Board {
    public int[][] board;
    public Point[] moves;
    int dimension = 9;

    public Board() {
        this.board = new int[dimension][dimension];
        this.moves = new Point[82];
    }

    public Board(int[][] board) {
        this.board = board;
        this.moves = new Point[82];
    }

    public List<Integer> checkOptions(Point point) {
        List<Integer> options = new ArrayList<>();
        List<Integer> possibleValues = new ArrayList<>();
        for (int x = 0; x < dimension; x++) {
            if (board[x][point.getY()] != 0) {
                options.add(board[x][point.getY()]);
            }
        }
        for (int y = 0; y < dimension; y++) {
            if (board[point.getX()][y] != 0) {
                options.add(board[point.getX()][y]);
            }
        }
        for (int x = checkBox(point.getX()); x < checkBox(point.getX()) + 3; x++) {
            for (int y = checkBox(point.getY()); y < checkBox(point.getY()) + 3; y++) {
                if (board[x][y] != 0) {
                    options.add(board[x][y]);
                }
            }
        }
        for (int x = 1; x <= dimension; x++) {
            if (!options.contains(x)) {
                possibleValues.add(x);
            }
        }
        return possibleValues;
    }

    private int checkBox(int value) {
        if (value < 3) {
            return 0;
        } else if (value < 6) {
            return 3;
        }
        return 6;
    }

    public Point findNextFreeSquare() {
        Point point;
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                if (board[x][y] == 0) {
                    point = new Point(x, y);
                    return point;
                }
            }
        }
        return null;
    }

    public int getFreeCells() {
        int freeCells = 0;
        for (int[] x : board) {
            for (int y : x) {
                if (y == 0) {
                    freeCells++;
                }
            }
        }
        return freeCells;
    }

    public void fill(int x, int y, int value) {
        board[x][y] = value;
    }

    public void setMove(Point p, int x) {
        moves[x] = p;
    }

    public void printBoard() {
        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public Board copy() {
        Board newBoard = new Board();
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                newBoard.fill(x, y, board[x][y]);
            }
        }
        return newBoard;
    }
}