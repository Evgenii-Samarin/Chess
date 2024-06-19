public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
        if (Math.abs(endLine - startLine) == Math.abs(endColumn - startColumn)) {
            int stepLine = (endLine > startLine) ? 1 : -1;
            int stepColumn = (endColumn > startColumn) ? 1 : -1;
            int currentLine = startLine + stepLine;
            int currentColumn = startColumn + stepColumn;
            while (currentLine != endLine && currentColumn != endColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false;
                }
                currentLine += stepLine;
                currentColumn += stepColumn;
            }
            return chessBoard.board[endLine][endColumn] == null || !chessBoard.board[endLine][endColumn].getColor().equals(getColor());
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}