package tictactoe;

import static tictactoe.Player.O;
import static tictactoe.Player.X;

public class Game {

    private Player currentPlayer;

    public Game() {
        currentPlayer = null;
    }

    private Game(Player nextPlayer) {
        this.currentPlayer = nextPlayer;
    }

    public GameState state() {
        return new GameState(Status.GAME_ON, nextPlayer());
    }

    private Player nextPlayer() {
        if(currentPlayer == null){
            return X;
        }
        return currentPlayer == X ? O : X;
    }

    public Game play() {
        return new Game(nextPlayer());
    }
}
