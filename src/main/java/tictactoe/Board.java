package tictactoe;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private final Set<Square> takenSquares;

    public Board() {
        takenSquares = new HashSet<Square>();
    }

    private Board(Set<Square> squares) {
        takenSquares = squares;
    }

    public boolean alreadyTaken(Square square) {
        return takenSquares.contains(square);
    }

    public Board take(Square square) {
        Set<Square> squares = new HashSet<Square>(takenSquares);
        squares.add(square);
        return new Board(squares);
    }

    public boolean isFull() {
        return this.takenSquares.size() == 9;
    }
}
