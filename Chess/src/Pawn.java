public class Pawn extends ChessPiece {
    public Pawn(String color) {
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
        int direction = color.equals("White") ? 1 : -1;
        if (startColumn == endColumn && (endLine == startLine + direction || (startLine == (color.equals("White") ? 1 : 6) && endLine == startLine + 2 * direction))) {
            if (chessBoard.board[endLine][endColumn] == null) {
                return true;
            }
        }
        if (Math.abs(endColumn - startColumn) == 1 && endLine == startLine + direction) {
            if (chessBoard.board[endLine][endColumn] != null && !chessBoard.board[endLine][endColumn].getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "P";
    }
}