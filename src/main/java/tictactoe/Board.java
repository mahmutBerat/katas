package tictactoe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static tictactoe.Square.*;

public class Board {

    private final Map<Square, Player> takenSquares;

    public Board() {
        takenSquares = new HashMap<>();
    }

    private Board(HashMap<Square, Player> squares) {
        takenSquares = squares;
    }

    public boolean alreadyTaken(Square square) {
        return takenSquares.containsKey(square);
    }

    public Board take(Square square, Player player) {
        HashMap<Square, Player> squares = new HashMap<>(takenSquares);
        squares.put(square, player);
        return new Board(squares);
    }

    public boolean isFull() {
        return this.takenSquares.size() == 9;
    }

    public boolean hasWon(Player currentPlayer) {
        Stream<Stream<Square>> winningMoves = Stream.of(
                Stream.of(TOP_LEFT, TOP_MIDDLE, TOP_RIGHT),
                Stream.of(CENTRE_LEFT, MIDDLE, CENTRE_RIGHT),
                Stream.of(BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT),
                Stream.of(BOTTOM_LEFT, MIDDLE, TOP_RIGHT),
                Stream.of(TOP_LEFT, MIDDLE, BOTTOM_RIGHT),
                Stream.of(TOP_LEFT, CENTRE_LEFT,BOTTOM_LEFT),
                Stream.of(TOP_MIDDLE, MIDDLE, BOTTOM_MIDDLE),
                Stream.of(TOP_RIGHT, CENTRE_RIGHT, BOTTOM_RIGHT)
        );
        return winningMoves.anyMatch(combo -> combo.allMatch(squaresTakenByPlayer(currentPlayer)::contains));
    }

    private Set<Square> squaresTakenByPlayer(Player player) {
        return takenSquares.entrySet().stream()
                .filter(entry -> entry.getValue().equals(player))
                .map(Map.Entry::getKey).collect(Collectors.toSet());
    }
}
