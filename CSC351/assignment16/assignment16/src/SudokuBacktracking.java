import java.util.List;

public class SudokuBacktracking extends BackTracking<Board> {
    private Board solution;

    SudokuBacktracking(Board board) {
        super.maxCandidates = board.dimension;
        int[] a = new int[82];
        backtrack(a, 81 - board.getFreeCells(), board);
    }

    @Override
    protected int constructCandidate(int[] a, int k, Board input, int[] candidates) {
        Point freeSquare = input.findNextFreeSquare();
        if (freeSquare == null) {
            return 0;
        }
        input.setMove(freeSquare, k);
        int choices = 0;
        List<Integer> checkOptions = input.checkOptions(freeSquare);
        for (int i = 0; i < checkOptions.size(); i++) {
            Integer option = checkOptions.get(i);
            candidates[i] = option;
            choices++;
        }
        return choices;
    }

    @Override
    protected void makeMove(int[] a, int k, Board input) {
        int valueToSet = a[k];
        Point location = input.moves[k];
        input.fill(location.getX(), location.getY(), valueToSet);
    }

    @Override
    protected void unmakeMove(int[] a, int k, Board input) {
        Point location = input.moves[k];
        input.fill(location.getX(), location.getY(), 0);
    }

    @Override
    protected boolean isSolution(int[] a, int k, Board input) {
        return input.getFreeCells() == 0;
    }

    @Override
    protected void processSolution(int[] a, int k, Board input) {
        input.printBoard();
        setSolution(input);
        finished = true;
    }

    public Board getSolution() {
        return solution;
    }

    public void setSolution(Board solution) {
        this.solution = solution.copy();
    }
}