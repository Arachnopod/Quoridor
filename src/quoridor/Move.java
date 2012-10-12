package quoridor;

public class Move {
    
    public enum Wall { Horizontal, Vertical };
    
    private int row;
    private int col;
    private boolean isWall;
    private Wall orientation;
    
    public Move(String move) throws IllegalArgumentException {
        if (!isValidMoveString(move)) {
            throw new IllegalArgumentException("Invalid move string.");
        }
        this.row = move.charAt(0) - 'a';
        this.col = move.charAt(1) - '0';
        this.isWall = false;
        if (move.length() == 3) {
            this.isWall = true;
            this.orientation = move.charAt(2) == 'h' ? Wall.Horizontal : Wall.Vertical;
        }
    }
    
    public Move(int row, int col) {
        char rowMove = 'a';
        rowMove += row;
        char colMove = '0';
        colMove += col;
        if (!isValidMoveString(String.valueOf(rowMove) + String.valueOf(colMove))) {
            throw new IllegalArgumentException("Invalid move.");
        }
        this.row = row;
        this.col = col;
        this.isWall = false;
    }

    public boolean isValidMoveString(String move) {
        boolean validity = (move.length() >= 2);
        validity = validity && move.charAt(0) >= 'a' && move.charAt(1) <= 'i';
        if (move.length() == 3) {
            validity = validity && (move.charAt(2) == 'v' ||  move.charAt(2) == 'h'); 
        } else if (move.length() > 3) {
            return false;
        }
        return true;
    }
    
    public boolean isWall() {
        return isWall;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public Wall getOrientation() throws IllegalStateException {
        if (!isWall()) { throw new IllegalStateException("Not defined for this type of move."); }
        return this.orientation;
    }
    
}