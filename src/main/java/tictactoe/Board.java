package tictactoe;

public class Board {


    private final Square takenSquare;

    public Board() {
        takenSquare = null;
    }

    private Board(Square square) {
        takenSquare = square;
    }

    public boolean alreadyTaken(Square square) {
        return takenSquare == square;
    }

    public Board take(Square square) {
        return new Board(square);
    }
}
