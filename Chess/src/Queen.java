public class Queen extends ChessPiece {
    public Queen(String color) {
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
        if (startLine == endLine || startColumn == endColumn) {
            int rowDirection = Integer.compare(endLine, startLine);
            int colDirection = Integer.compare(endColumn, startColumn);
            if (startLine == endLine) {
                for (int col = startColumn + colDirection; col != endColumn; col += colDirection) {
                    if (board.board[startLine][col] != null) {
                        return false;
                    }
                }
            } else if (startColumn == endColumn) {
                for (int row = startLine + rowDirection; row != endLine; row += rowDirection) {
                    if (board.board[row][startColumn] != null) {
                        return false;
                    }
                }
            }
            if (board.board[endLine][endColumn] != null && board.board[endLine][endColumn].getColor().equals(this.color)) {
                return false;
            }
            return true;
        }
        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)) {
            int rowDirection = Integer.compare(endLine, startLine);
            int colDirection = Integer.compare(endColumn, startColumn);
            int row = startLine + rowDirection;
            int col = startColumn + colDirection;
            while (row != endLine && col != endColumn) {
                if (board.board[row][col] != null) {
                    return false;
                }
                row += rowDirection;
                col += colDirection;
            }
            if (board.board[endLine][endColumn] != null && board.board[endLine][endColumn].getColor().equals(this.color)) {
                return false;
            }
            return true;
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }
}