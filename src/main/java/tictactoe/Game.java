package tictactoe;

import static tictactoe.Player.*;
import static tictactoe.Status.*;

public class Game {

    private Status status;
    private Board board;
    private Player currentPlayer;

    public Game() {
        currentPlayer = null;
        board = new Board();
        status = GAME_ON;
    }

    private Game(Status status, Board board, Player currentPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.status = status;
        this.status = setStatusByBoard(board);
    }

    private Status setStatusByBoard(Board board) {
        if (board.hasWon(currentPlayer))
            return currentPlayer == X ? X_HAS_WON : O_HAS_WON;
        if (board.isFull()) return DRAW;
        return status;
    }

    public GameState state() {
        return gameIsOver() ? new GameState(status, NOBODY) : new GameState(status, nextPlayer());
    }

    private boolean gameIsOver() {
        return status == DRAW || status == X_HAS_WON || status == O_HAS_WON;
    }

    private Player nextPlayer() {
        if (currentPlayer == null) {
            return X;
        }
        return currentPlayer == X ? O : X;
    }

    public Game play(Square square) {
        if(gameIsOver()){
            return this;
        }
        if (board.alreadyTaken(square)) {
            return new Game(SQUARE_ALREADY_PLAYED, board, currentPlayer);
        }
        return new Game(GAME_ON, board.take(square, nextPlayer()), nextPlayer());
    }
}
