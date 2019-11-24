package tictactoe;

public class Game {

    private GameState state;

    public GameState getState() {
        return new GameState(Status.GAME_ON, Player.X);
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
