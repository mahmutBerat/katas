package tictactoe;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static tictactoe.Square.*;

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
        Set<Square> squares = new HashSet<>(takenSquares);
        squares.add(square);
        return new Board(squares);
    }

    public boolean isFull() {
        return this.takenSquares.size() == 9;
    }

    public boolean hasWon() {
        Stream<Stream<Square>> winningMoves = Stream.of(
                Stream.of(TOP_LEFT, TOP_MIDDLE, TOP_RIGHT),
                Stream.of(CENTRE_LEFT, MIDDLE, CENTRE_RIGHT),
                Stream.of(BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT),
                Stream.of(BOTTOM_LEFT, MIDDLE, TOP_RIGHT),
                Stream.of(TOP_LEFT, MIDDLE, BOTTOM_RIGHT),
                Stream.of(TOP_MIDDLE, MIDDLE, BOTTOM_MIDDLE),
                Stream.of(TOP_RIGHT, CENTRE_RIGHT, BOTTOM_RIGHT)
        );
        return winningMoves.anyMatch(combo -> combo.allMatch(takenSquares::contains));
    }
}
