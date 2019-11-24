import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tictactoe.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tictactoe.Player.NOBODY;
import static tictactoe.Player.X;
import static tictactoe.Square.*;
import static tictactoe.Status.*;


@DisplayName("Game adjudicator should ")
public class GameShould {

    @Test
    public void wait_for_x_to_play_first() {
        Game game = new Game();

        assertThat(game.state(), is(new GameState(GAME_ON, X)));
    }

    @Test
    public void alternate_the_players() {
        Game game = play(TOP_LEFT, MIDDLE);

        assertThat(game.state(), is(new GameState(GAME_ON, X)));
    }

    @Test
    public void not_allow_a_square_already_played() {
        Game game = play(TOP_LEFT, MIDDLE, TOP_LEFT);

        assertThat(game.state(), is(new GameState(SQUARE_ALREADY_PLAYED, X)));
    }

    private Game play(Square... squares) {
        return Arrays.stream(squares)
                .reduce(new Game(), Game::play, (a, b) -> null);
    }

    // x o x
    // o o x
    // x x o
    @Test
    public void recognize_a_draw() {
        Game game = play(TOP_LEFT, TOP_MIDDLE, TOP_RIGHT,
                CENTRE_LEFT, BOTTOM_LEFT, MIDDLE,
                CENTRE_RIGHT, BOTTOM_RIGHT, BOTTOM_MIDDLE);

        assertThat(game.state(), is(new GameState(DRAW, NOBODY)));
    }

}
