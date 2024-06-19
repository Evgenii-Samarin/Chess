public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return this.color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard board, int startLine, int startColumn, int endLine, int endColumn) {
        if (!board.checkPos(startLine) || !board.checkPos(startColumn) || !board.checkPos(endLine) || !board.checkPos(endColumn)) {
            return false;
        }
        if (startLine == endLine && startColumn == endColumn) {
            return false;
        }
        if (Math.abs(startLine - endLine) <= 1 && Math.abs(startColumn - endColumn) <= 1) {
            return board.board[endLine][endColumn] == null || !board.board[endLine][endColumn].getColor().equals(getColor());
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "K";
    }
    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j] != null && !board.board[i][j].getColor().equals(this.color)) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}