public class Rook extends ChessPiece {
    public Rook(String color) {
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
        if (startLine == endLine || startColumn == endColumn) {
            if (startLine == endLine) {
                int stepColumn = (endColumn > startColumn) ? 1 : -1;
                int currentColumn = startColumn + stepColumn;
                while (currentColumn != endColumn) {
                    if (chessBoard.board[startLine][currentColumn] != null) {
                        return false;
                    }
                    currentColumn += stepColumn;
                }
            } else {
                int stepLine = (endLine > startLine) ? 1 : -1;
                int currentLine = startLine + stepLine;
                while (currentLine != endLine) {
                    if (chessBoard.board[currentLine][startColumn] != null) {
                        return false;
                    }
                    currentLine += stepLine;
                }
            }
            return chessBoard.board[endLine][endColumn] == null || !chessBoard.board[endLine][endColumn].getColor().equals(getColor());
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "R";
    }
}