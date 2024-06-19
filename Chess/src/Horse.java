public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int startLine, int startColumn, int endLine, int endColumn) {
        if (!chessBoard.checkPos(startLine) || !chessBoard.checkPos(startColumn) || !chessBoard.checkPos(endLine) || !chessBoard.checkPos(endColumn)) {
            return false;
        }
        if (startLine == endLine && startColumn == endColumn) {
            return false;
        }
        if ((Math.abs(endLine - startLine) == 2 && Math.abs(endColumn - startColumn) == 1) ||
                (Math.abs(endLine - startLine) == 1 && Math.abs(endColumn - startColumn) == 2)) {
            return chessBoard.board[endLine][endColumn] == null || !chessBoard.board[endLine][endColumn].getColor().equals(getColor());
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "H";
    }
}