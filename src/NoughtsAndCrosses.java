public class NoughtsAndCrosses {
    private final int[][] board;
    private final int NONE = 0;
    private final int NOUGHTS = 1;
    private final int CROSSES = 2;

    public NoughtsAndCrosses(int[][] board) {
        this.board = board;
    }

    public int checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]
                    && board[i][0] != NONE) {
                return board[i][0] == NOUGHTS ? NOUGHTS : CROSSES;
            }
        }
        return -1;
    }

    public int checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]
                    && board[0][i] != NONE) {
                return board[0][i] == NOUGHTS ? NOUGHTS : CROSSES;
            }
        }
        return -1;
    }

    public int checkDiagonal() {
        if (board[1][1] != 0
                && ((board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0]))) {
            return board[1][1] == NOUGHTS ? NOUGHTS : CROSSES;
        } else {
            return -1;
        }
    }

    public int whoWon() {
        int row = checkRows();
        int column = checkColumns();
        int diagonal = checkDiagonal();
        return row != -1 ? row : column != -1 ? column : diagonal != -1 ? diagonal : 0;
    }

    public boolean isDraw() {
        return whoWon() == 0;
    }


}
